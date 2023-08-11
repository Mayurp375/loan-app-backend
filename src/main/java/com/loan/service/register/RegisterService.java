package com.loan.service.register;

import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import com.loan.service.mailsender.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterService implements RegistrationInterface {


    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    Mail mail;

    @Override
    public User register(User user) {
        return registrationRepo.save(user);
    }

}
