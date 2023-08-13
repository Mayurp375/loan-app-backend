package com.loan.service.login;

import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImp implements LoginService{

    @Autowired
    RegistrationRepo registrationRepo;
    @Override
    public User validateUser(String email, String password) {
        return registrationRepo.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}
