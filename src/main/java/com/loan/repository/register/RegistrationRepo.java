package com.loan.repository.register;

import com.loan.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<User,Long> {
}
