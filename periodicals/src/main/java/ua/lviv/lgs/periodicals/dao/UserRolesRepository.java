package ua.lviv.lgs.periodicals.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.periodicals.domain.UserRole;

import java.util.List;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Integer> {

    @Query("select a.role from UserRole a, user b where b.userName=:username and a.userId=b.userId")
    List<String> findRolesByUserName(@Param("username") String username);

}
