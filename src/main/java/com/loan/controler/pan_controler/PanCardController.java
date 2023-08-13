package com.loan.controler.pan_controler;


import com.loan.service.pan.PanCardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanCardController {

    @PostMapping("/validate-pan")
    public ResponseEntity<String> validatePan(@Validated @RequestBody PanCardDto panCardDto) {
        return ResponseEntity.ok("PAN card is valid!");
    }
}
