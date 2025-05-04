package com.example.login_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_service.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-v1")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private AuthService authService;

    // TODO: Borrar endpoint al terminar pruebas de autenticación JWT
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerCliente(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> validateCliente(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login());
    }
    // TODO: Check what dependencies aren't necessary.
    // TODO: Generate a JWToken for security purposes.
}
