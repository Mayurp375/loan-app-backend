package com.loan.utility.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtTocken {
    private static final String TOKEN_SECRET = "Warlock";


    public String createToken(int id)   {
        try {
            //to set algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            String token = JWT.create()
                    .withClaim("user_id", id)
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //log Token Signing Failed
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
