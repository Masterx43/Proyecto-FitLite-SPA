package com.example.login_service.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY="qv8U9X1KZPiRYg2MxU4WfKbiNjG3N1qQzBe2uZSpMCo0p1ViPwEXq5MfHLfKv0TS";

    public String getToken(UserDetails cliente) {
        return getToken(new HashMap<>(), cliente);
    }

    private String getToken(Map<String,Object> extractClaims, UserDetails cliente) {
        return Jwts
            .builder()
            .setClaims(extractClaims)
            .setSubject(cliente.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
