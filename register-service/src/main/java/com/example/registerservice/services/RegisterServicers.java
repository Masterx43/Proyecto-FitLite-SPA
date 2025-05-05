package com.example.registerservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerservice.model.Cliente;
import com.example.registerservice.repository.RegistroRepository;

@Service
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



    //dr prueba
    //1

    public List<Cliente> obtenercliente(){
        return registroRepository.findAll();
    }

    //3

    public Boolean BorrarCliente(Integer Id){
        if(registroRepository.existsById(Id)){
            registroRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    //2
    public Cliente getClienteByEmail(Cliente cliente) {
        for (Cliente c : registroRepository.findAll()) {
            if (c.getEmail() == cliente.getEmail()) {
                return cliente;
            }
        }
        return null;
    }

    //4
    
    public Cliente findbyId(Integer id) {
        return registroRepository.findById(id).orElse(null); 
    }

    //5
    public Cliente save(Cliente cliente) {
        return registroRepository.save(cliente);
    }





}
