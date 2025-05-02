package com.example.login_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.login_service.model.Cliente;
import com.example.login_service.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // isPresent() es para que, en vez de devolver al cliente, devuelva boolean, para validar más adelante
    // Esto devolvería sin el isPresent() = True: Optional<Cliente> ( usar .get() ) || False: Optional<>.isEmpty()
    public Boolean checkClienteByEmail(String email) {
        return clienteRepository.findByEmail(email).isPresent(); 
    }

    public String encrypt(String rawPasswd) {
        return passwordEncoder.encode(rawPasswd);
    }

    public boolean validateCliente(String email, String password) {
        if (!checkClienteByEmail(email)) { // Validar si existe en base de datos.
            return false; 
        }

        Cliente cliente = clienteRepository.findByEmail(email).get();
        if (passwordEncoder.matches(password, cliente.getPassword())) {
            return true; 

        }

        return false;
    }
}

