package com.loan.service.register;

import com.loan.entity.User.OtpValidationRequest;
import com.loan.entity.User.User;


public interface RegistrationInterface {
    User register(User user);

    String validateOtp(OtpValidationRequest otpValidationRequest);

    boolean verifyOtp(String email, String otp);
}
