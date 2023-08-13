package com.loan.controler.registration;

import com.loan.entity.User.User;
import com.loan.service.mailsender.MailSendere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtpVerify {

    @Autowired
    private MailSendere mailSendere;

    @GetMapping("/otp-verify/{otp}")
    public ResponseEntity<String> otpVerify(@PathVariable("otp") String otp) {
        return new ResponseEntity(otp, HttpStatus.OK);
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<Boolean> validateOtp(@RequestBody User user) {
        boolean validateOtp = false;
        try{
            if (validateOtp){
                mailSendere.validateOtp(user.getOtp(), user);
                System.out.println("validate");
            }else {
                System.out.println("otp not validate");
            }
        }catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity(validateOtp,HttpStatus.OK);
    }
}



