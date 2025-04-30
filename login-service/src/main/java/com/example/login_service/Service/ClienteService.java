package com.example.login_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login_service.model.Cliente;
import com.example.login_service.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean validateCliente(String email, String password) {
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getEmail() == email && cliente.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}

