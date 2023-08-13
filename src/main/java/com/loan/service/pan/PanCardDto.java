package com.loan.service.pan;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PanCardDto {

    @NotNull(message = "PAN card number cannot be null.")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Invalid PAN card format.")
    private String panNumber;

    // getters and setters
}
