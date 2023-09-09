package com.loan.repository.register;

import com.loan.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepo extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM user where email= :email",nativeQuery = true)
    Optional<User> findByEmail(String email);

//    @Query(value = "SELECT * FROM user where email= :emailId",nativeQuery = true)
//    User findByEmailid(String emailId);

}
