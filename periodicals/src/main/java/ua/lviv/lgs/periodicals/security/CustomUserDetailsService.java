package ua.lviv.lgs.periodicals.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.periodicals.dao.UserRepository;
import ua.lviv.lgs.periodicals.dao.UserRolesRepository;
import ua.lviv.lgs.periodicals.domain.User;

import java.util.List;
import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
            List<String> userRoles = userRolesRepository.findRolesByUserName(email);
            return new CustomUserDetails(userOptional.get(), userRoles);
        }

        throw new UsernameNotFoundException("No user present with useremail" + email);
    }
}
