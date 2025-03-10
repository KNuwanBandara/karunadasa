package lk.learners.karunadasa.Security.dao;


import lk.learners.karunadasa.Security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "select id from User where employee_id=?1", nativeQuery = true)
    Integer findByEmployeeId(@Param("employee_id") Integer id);

    @Query("select id from User where username=?1")
    Integer findUserIdByUserName(String userName);

    Optional<User> findByUsername(String name);
}
