package com.loan.service.cibil;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CibilScoreService {

    private static final int MIN_CIBIL_SCORE = 300;
    private static final int MAX_CIBIL_SCORE = 900;

    public int generateRandomCibilScore() {
        Random random = new Random();
        return random.nextInt(MAX_CIBIL_SCORE - MIN_CIBIL_SCORE + 1) + MIN_CIBIL_SCORE;
    }

    public String evaluateCibilScore(int score) {
        if (score < 500) {
            return "Poor";
        } else if (score < 650) {
            return "Average";
        } else if (score < 750) {
            return "Good";
        } else {
            return "Excellent";
        }
    }
}
