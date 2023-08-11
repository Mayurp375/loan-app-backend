package com.loan.service.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MailSendere {

    @Autowired
    private JavaMailSender mailSender;

    private Map<String, String> otpData = new HashMap<>();

    public void sendOtp(String toEmail) {
        String otp = generateOtp();
        otpData.put(toEmail, otp); // Store OTP for validation

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        System.out.printf("otp "+ otp);
        mailSender.send(message);
    }

    public boolean validateOtp(String email, String userInputOtp) {
        String validOtp = otpData.get(email);
        return validOtp != null && validOtp.equals(userInputOtp);
    }

    public static String generateOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}



