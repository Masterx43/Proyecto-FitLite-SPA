package com.example.registerservice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.registerservice.model.Cliente;
import com.example.registerservice.repository.RegistroRepository;

public class RegisterServicers {

    @Autowired
    private RegistroRepository registroRepository;


    public Cliente CrearCliente(Cliente cliente){
        for(Cliente c : registroRepository.findAll()){
            if(c.getEmail().equals(cliente.getEmail())){
                throw new IllegalArgumentException("El correo ya ha sido registrado previamente");
            }
        }
        return registroRepository.save(cliente);
    }


    public Cliente getClienteByEmail(Cliente cliente) {
        for (Cliente c : registroRepository.findAll()) {
            if (c.getEmail() == cliente.getEmail()) {
                return cliente;
            }
        }
        return null;
    }




}
