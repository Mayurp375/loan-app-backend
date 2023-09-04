package com.loan.controler.pan_controler;


import com.loan.service.cibil.CibilScoreService;
import com.loan.service.pan.PanCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pan-card")
@CrossOrigin(origins = "http://localhost:4200")
public class PanCardAndCibilScoreController {

    @Autowired
    private CibilScoreService cibilScoreService;

    //http://localhost:8080/pan-card/validate-pan
    @PostMapping("/validate-pan")
    public ResponseEntity<String> validatePan(@Validated @RequestBody PanCardDto panCardDto) {
        int score = cibilScoreService.generateRandomCibilScore();
        String evaluation = cibilScoreService.evaluateCibilScore(score);
        String massage= "PAN card is valid. CIBIL Score: " + score + " (" + evaluation + ")";
        return new ResponseEntity<>(massage, HttpStatus.OK) ;
    }
}
