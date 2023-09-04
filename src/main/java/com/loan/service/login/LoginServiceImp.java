package com.loan.service.login;

import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImp implements LoginService{

    @Autowired
    RegistrationRepo registrationRepo;
    @Override
    public User validateUser(String email, String password) {
        log.info(email);
        log.info(password);
        return registrationRepo.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }

}
