package com.loan.service.register;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;
import com.loan.repository.register.RegistrationRepo;
import com.loan.service.mailsender.MailSendere;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class RegisterService implements RegistrationInterface {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    MailSendere mailSendere;

    Map<String, String> otpMap = new HashMap<>();
    Map<String, User> temporaryUsers = new HashMap<>();

    public User register(User user) {
        String otp = MailSendere.generateOtp();
        mailSendere.sendSimpleEmail(user.getEmail(), otp, "Your requested One time password");
        otpMap.put(user.getEmail(), otp);
        temporaryUsers.put(user.getEmail(), user);
        System.out.println(otp);
        return user;  // Just return the user, don't save in the database yet
    }

    public String validateOtp(OtpValidationRequest otpValidationRequest) {

        if (registrationRepo.findByEmail(otpValidationRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        String storedOtp = otpMap.get(otpValidationRequest.getEmail());

        log.info("Validating OTP for Email: " + otpValidationRequest.getEmail());
        log.info("Received OTP: " + otpValidationRequest.getOtpNumber());
        log.info("Stored OTP: " + storedOtp);

        if (storedOtp == null) {
            log.warn("Stored OTP is null");
            return "OTP is invalid!";
        }

        if (storedOtp.equalsIgnoreCase(otpValidationRequest.getOtpNumber().toString())) {
            User userToRegister = temporaryUsers.get(otpValidationRequest.getEmail());
            registrationRepo.save(userToRegister); // Register the user now
            otpMap.remove(otpValidationRequest.getEmail());
            temporaryUsers.remove(otpValidationRequest.getEmail());
            return "OTP is valid and user registered!";
        } else {
            return "OTP is invalid!";
        }
    }


    public boolean verifyOtp(String email, String otp) {
        mailSendere.sendSimpleEmail(email, otp, "Your requested One time password");
        String storedOtp = otpMap.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            otpMap.remove(email);
            return true;
        }
        return false;
    }

    public String generateOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(999999)); // 6-digit OTP
        otpMap.put(email, otp);
        // Send OTP to the email here (e.g., via email service)
        return otp;
    }

    public void updatePassword(String email, String newPassword) {
        User user = registrationRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword); // Should be encrypted
        registrationRepo.save(user);
    }



}
