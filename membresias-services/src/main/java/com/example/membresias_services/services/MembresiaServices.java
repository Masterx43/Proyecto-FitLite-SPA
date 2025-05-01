package com.example.membresias_services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.membresias_services.model.Membresias;
import com.example.membresias_services.repository.MembresiaRepository;

@Service
public class MembresiaServices {

    @Autowired
    private MembresiaRepository membresiaRepository;

    public Membresias AgregarMembresia(Membresias membresia){
        return membresiaRepository.save(membresia);
    }

    public List<Membresias> ObtenerMembresia(){
        return membresiaRepository.findAll();
    }

    public Boolean BorrarMembresias(Integer Id){
        if(membresiaRepository.existsById(Id)){
            membresiaRepository.deleteById(Id);
            return true;
        }
        return false;
    }

    public Membresias findbyId(Integer id) {
        return membresiaRepository.findById(id).orElse(null); 
    }

    public Membresias save(Membresias membresia) {
        return membresiaRepository.save(membresia);
    }

}
