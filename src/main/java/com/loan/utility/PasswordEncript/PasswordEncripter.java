package com.loan.utility.PasswordEncript;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
public class PasswordEncripter {

    private static final String SECRET_KEY = "MYSecretKey";

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours token validity
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims decodeToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);

        return claimsJws.getBody();
    }
}
