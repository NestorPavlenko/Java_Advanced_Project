package ua.lviv.lgs.periodicals.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.periodicals.dao.UserRepository;
import ua.lviv.lgs.periodicals.domain.User;
import ua.lviv.lgs.periodicals.domain.UserRole;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(PeriodicalsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save (User user) {
        logger.debug("Register new user {} : "+user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return null;
    }
}
