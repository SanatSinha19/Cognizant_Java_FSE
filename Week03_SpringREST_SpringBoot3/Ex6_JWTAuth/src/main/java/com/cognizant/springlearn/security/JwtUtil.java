package com.cognizant.springlearn.security;

import java.util.Date;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 20 * 60 * 1000))
                .signWith(key)
                .compact();
    }
}