package com.project.aiSaas.utilty;



import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

  private static final  String SECRET_KEY = "YourSuperSecretKeyMustBeVeryLongAndSecureToPreventBruteForceAttacks";

     private static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
// private  => es class ke bhara not access 
// secretKey => returntype
//getSigningKey()  userndefine name ??
// Decoders.BASE64.decode

 public static String createToken(String email) throws InvalidKeyException {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 60000*15))
                .signWith(getSigningKey(), Jwts.SIG.HS256) // Securely sign the token
                .compact();
    }


   

public String extrClaimsMail( String token){



    return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
}


}
