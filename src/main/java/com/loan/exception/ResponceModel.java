package com.loan.exception;

import lombok.Data;

@Data
public class ResponceModel {
    private final String message;

    public ResponceModel(String adminNotFound) {
        this.message = adminNotFound;
    }
}
