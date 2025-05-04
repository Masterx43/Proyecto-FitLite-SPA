package com.example.paymentManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentManager.model.Pago;
import com.example.paymentManager.repository.PagoRepository;

@Service
public class PagoServices {
    @Autowired
    private PagoRepository pagoRepository;

    public Pago agregarPago(Pago pag){
        return pagoRepository.save(pag);
    }

    public List<Pago> ListarPagos(){
        return pagoRepository.findAll();
    }

    public List<Pago> buscarPagosUsuario(Integer id){
        return pagoRepository.findByIdUsuario(id);
    }

    public Pago buscarPagoId(int id){
        return pagoRepository.findById(id).orElse(null);
    }

    public Boolean borrarPago(int id){
        if (pagoRepository.existsById(id)){
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Pago actualizarPago(Pago pag){
        return pagoRepository.save(pag);
    }
}
