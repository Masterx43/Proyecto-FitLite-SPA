package com.example.perfilcliente_services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.perfilcliente_services.model.Cliente;
import com.example.perfilcliente_services.repository.PerfilClienteRepository;

@Service
public class PerfilClienteServices {

    @Autowired
    private PerfilClienteRepository perfilClienteRepository;

    public Boolean checkClienteByEmail(String email) {
        return perfilClienteRepository.findByEmail(email).isPresent(); 
    }

    public Cliente save(Cliente cliente) {

        return perfilClienteRepository.save(cliente);
    }
    
    public Boolean BorrarPorcliente(String email){
        if(perfilClienteRepository.findByEmail(email).isPresent()){
            perfilClienteRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }

    



}
