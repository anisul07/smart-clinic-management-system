package com.project.back_end.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    public String generateToken(String username) {
        return username + "-" + UUID.randomUUID();
    }

    public boolean validateToken(String token) {
        return token != null && !token.trim().isEmpty();
    }
}
