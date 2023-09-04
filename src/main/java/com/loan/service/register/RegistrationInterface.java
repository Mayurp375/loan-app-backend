package com.loan.service.register;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;


public interface RegistrationInterface {
    public User register(User user);
    public String validateOtp(OtpValidationRequest otpValidationRequest);



    boolean verifyOtp(String email, String otp);
}
