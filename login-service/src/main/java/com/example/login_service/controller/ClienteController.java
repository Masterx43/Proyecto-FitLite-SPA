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
        List<Cliente> hola = clienteService.getClientes();
        if (hola.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hola);
    }

    @PostMapping("/hola1")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        Cliente cliente1 = clienteService.addCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente1);
    }

    @PostMapping("/hola")
    public ResponseEntity<String> validarclientesaquíporfavorusenestemetodouwu(@RequestBody Cliente clienteRequest) {
        boolean request = clienteService.validateCliente(clienteRequest.getEmail(), clienteRequest.getPassword());
        if (request) {
            return ResponseEntity.ok("yeppi");
        } else{
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("yeppin't");
        }
    }
}
