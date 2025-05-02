package com.example.login_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_service.model.Cliente;
import com.example.login_service.service.ClienteService;

@RestController
@RequestMapping("/api-v1/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/login")
    public ResponseEntity<String> validateCliente(@RequestBody Cliente clienteRequest) {
        boolean request = clienteService.validateCliente(clienteRequest.getEmail(), clienteRequest.getPassword());
        if (request) {
            return ResponseEntity.ok("Sesión iniciada.");
        } else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación.");
        }
    }
}
