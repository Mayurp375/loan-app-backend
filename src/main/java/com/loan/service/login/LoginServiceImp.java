package com.loan.service.login;

import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import com.loan.utility.jwt.JwtTocken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImp implements LoginService {

    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    JwtTocken jwtTocken;

    @Override
    public String validateUser(String email, String password) {
//        log.atTrace();
//        User findByEmail = registrationRepo.findByEmail(email)
//                .filter(user -> user.getPassword().equals(password))
//                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
//        String token = jwtTocken.createToken(findByEmail.getId());
//        return token;
        User user = registrationRepo.findByEmail(email).orElse(null);

        if (user != null && user.getPassword().equals(password)) {
            return jwtTocken.createToken(user.getId());
        }

        throw new RuntimeException("Invalid email or password");
    }
}
