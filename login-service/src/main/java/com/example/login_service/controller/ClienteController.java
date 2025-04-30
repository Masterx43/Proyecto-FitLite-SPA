package com.example.login_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_service.model.Cliente;
import com.example.login_service.service.ClienteService;

@RestController
@RequestMapping("/api-v1/login")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = clienteService.getClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/add")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente cliente1 = clienteService.addCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente1);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateCliente(@RequestBody Cliente clienteRequest) {
        boolean request = clienteService.validateCliente(clienteRequest.getEmail(), clienteRequest.getPassword());
        if (request) {
            return ResponseEntity.ok("Cliente añadido.");
        } else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error.");
        }
    }
}
