package com.loan.controler.registration;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;
import com.loan.service.register.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1")
public class OtpVerify {

    @Autowired
    RegisterService registerService;


    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody User otpRequest) {
        log.info("Inside sendOtp for Email: " + otpRequest.getEmail());
        registerService.register(otpRequest);
        return "OTP sent successfully to " + otpRequest.getEmail();
    }

    @PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
        log.info("Inside validateOtp for Email: " + otpValidationRequest.getEmail());
        return registerService.validateOtp(otpValidationRequest);
    }
}
