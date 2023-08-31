package com.loan.entity.User.dto;

import org.springframework.web.multipart.MultipartFile;

public class ExtendedUserProfileDTO {
    private String bankAccountNumber;
    private MultipartFile bankStatementFile;
    private String aadhaarCardNumber;
    private MultipartFile aadhaarCardFile;
    private Integer cibilScore;



    // getters, setters, etc.
}
