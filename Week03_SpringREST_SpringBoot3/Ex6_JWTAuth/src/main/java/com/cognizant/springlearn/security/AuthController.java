package com.cognizant.springlearn.security;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    private static final String VALID_USER = "user";
    private static final String VALID_PWD = "pwd";

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        String[] parts = decoded.split(":", 2);
        String username = parts[0];
        String password = parts[1];

        if (VALID_USER.equals(username) && VALID_PWD.equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}