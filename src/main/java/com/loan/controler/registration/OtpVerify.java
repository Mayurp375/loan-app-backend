package com.loan.controler.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpVerify {


    public ResponseEntity<String> otpVerify(){


        return ResponseEntity.ok();
    }
}
