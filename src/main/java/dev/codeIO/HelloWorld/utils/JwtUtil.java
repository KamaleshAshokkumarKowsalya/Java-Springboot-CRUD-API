package dev.codeIO.HelloWorld.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "No, object relations are indeed a fundamental part of object-relational databases (ORDBMS). The model explicitly integrates object-oriented concepts, including";
    private final long EXPIRATION = 1000*60;
    private final Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

    }
    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validJwtToken(String token){
        try{
            extractEmail(token);
            return true;

        } catch (JwtException e) {
            return false;
        }
    }

}
