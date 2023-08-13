package com.loan.service.mailsender;

import com.loan.entity.User.User;
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

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("mayurpolojwar1234@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send ...");
    }

    public boolean validateOtp(String otp, User user) {
        if (otp.equals(user.getOtp())) {
            return true;
        } else {
            return false;
        }
    }

    public static String generateOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}



