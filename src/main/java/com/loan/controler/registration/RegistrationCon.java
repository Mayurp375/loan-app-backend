package com.loan.controler.registration;

import com.loan.entity.User.User;
import com.loan.service.register.RegistrationInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vi")
@Slf4j
public class RegistrationCon {

    @Autowired
    RegistrationInterface registrationInterface;

    @Autowired
    OtpVerify otpVerify;


//    http://localhost:8080/vi/hello

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, World!");
    }


//    http://localhost:8080/vi/register

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        log.info("inside registration method");


        User build = User.builder().email(user.getEmail()).otp(user.getOtp()).build();

        User register = null;
        try {
            otpVerify.validateOtp(build);
            register = registrationInterface.register(user);
        } catch (Exception e) {
            e.getMessage();
        }

        return new ResponseEntity<>(register, HttpStatus.OK);
    }
}
