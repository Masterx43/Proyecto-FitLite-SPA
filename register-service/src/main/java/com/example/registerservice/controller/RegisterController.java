package com.example.registerservice.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.model.Cliente;
import com.example.registerservice.services.RegisterServicers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

 
@RestController
@RequestMapping("/api-v1/register")
public class RegisterController {

    @Autowired
    private RegisterServicers registerServicers;
   
    @PostMapping("/agregarCliente")
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente) {

        registerServicers.CrearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    
    
}
