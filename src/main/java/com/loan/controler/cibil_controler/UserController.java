package com.loan.controler.cibil_controler;

import com.loan.entity.User.User;
import com.loan.service.cibil.CibilScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cibil")
public class UserController {

    @Autowired
    private CibilScoreService cibilScoreService;

    @PostMapping("/validatePanAndScore")
    public String validateAndScore(@Valid @RequestBody User user) {
        int score = cibilScoreService.generateRandomCibilScore();
        String evaluation = cibilScoreService.evaluateCibilScore(score);
        return "PAN card is valid. CIBIL Score: " + score + " (" + evaluation + ")";
    }
}
