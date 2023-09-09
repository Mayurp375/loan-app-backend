package com.loan.controler.registration;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;
import com.loan.service.register.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")   //
public class RegistrationAndUpdatePassword {

    @Autowired
    RegisterService registerService;

    //http://localhost:8080/v1/send-otp
    @PostMapping("/send-otp")
    public ResponseEntity<Map<String, String>> sendOtp(@RequestBody User otpRequest) {
        log.info("Inside sendOtp for Email: " + otpRequest.getEmail());
        registerService.register(otpRequest);
        Map<String, String> response = new HashMap<>();
        response.put("message", "OTP sent successfully to " + otpRequest.getEmail());
        return ResponseEntity.ok(response);
    }


    // http://localhost:8080/v1/validate-otp
    @PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
        log.info("Inside validateOtp for Email: " + otpValidationRequest.getEmail());
        return  registerService.validateOtp(otpValidationRequest);

    }


    // http://localhost:8080/v1/reset/generate-otp


    @PostMapping("/reset/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam String email) {
        String otp = registerService.updatePasswodOtp(email);
        return ResponseEntity.ok("OTP sent to " + email + ". (For testing purposes, OTP is: " + otp + ")");
    }


    // http://localhost:8080/v1/reset/update-password

    @PatchMapping("/reset/update-password")
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
