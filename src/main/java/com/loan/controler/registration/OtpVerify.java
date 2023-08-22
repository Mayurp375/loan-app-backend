package com.loan.controler.registration;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;
import com.loan.service.register.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1")
public class OtpVerify {

    @Autowired
    RegisterService registerService;

//http://localhost:8080/v1/send-otp
    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody User otpRequest) {
        log.info("Inside sendOtp for Email: " + otpRequest.getEmail());
        registerService.register(otpRequest);
        return "OTP sent successfully to " + otpRequest.getEmail();
    }

   // http://localhost:8080/v1/validate-otp
    @PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
        log.info("Inside validateOtp for Email: " + otpValidationRequest.getEmail());
        return registerService.validateOtp(otpValidationRequest);
    }


    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam String email) {
        String otp = registerService.generateOtp(email);
        return ResponseEntity.ok("OTP sent to " + email + ". (For testing purposes, OTP is: " + otp + ")");
    }

    @PatchMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestParam String email,
                                                 @RequestParam String otp,
                                                 @RequestParam String newPassword) {
        if (registerService.verifyOtp(email, otp)) {
            registerService.updatePassword(email, newPassword);
            return ResponseEntity.ok("Password updated successfully!");
        }
        return ResponseEntity.badRequest().body("Invalid OTP.");
    }


}
