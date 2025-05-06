package com.example.perfilcliente_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.perfilcliente_services.model.Cliente;
import com.example.perfilcliente_services.services.PerfilClienteServices;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api-v1/perfilcliente")
public class PerfilClienteController {

    @Autowired
    private PerfilClienteServices perfilClienteServices;

    @PutMapping("/{id}")
    public ResponseEntity<String> ModificarCliente(@PathVariable Integer id,@RequestBody Cliente cliente){
        try {
            boolean existe = perfilClienteServices.checkClienteByEmail(cliente.getEmail());
            if(!existe){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente inexistente.");
            }

            Cliente cliente2 = new Cliente();
            cliente2.setIdCliente(id);
            cliente2.setPnombre(cliente.getPnombre());
            cliente2.setSnombre(cliente.getSnombre());
            cliente2.setAppaterno(cliente.getAppaterno());
            cliente2.setApmaterno(cliente.getApmaterno());
            cliente2.setEdad(cliente.getEdad());
            cliente2.setEmail(cliente.getEmail());
            cliente2.setPassword(cliente.getPassword());
            cliente2.setTelefono(cliente.getTelefono());
            cliente2.setDireccion(cliente.getDireccion());
            cliente2.setFechaRegistro(cliente.getFechaRegistro());

            perfilClienteServices.save(cliente2);
            return ResponseEntity.ok("Cliente Modificado Exitosamente");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> EliminarCliente (@PathVariable String email){
        boolean eliminar = perfilClienteServices.BorrarPorcliente(email);
        if(eliminar){
            return ResponseEntity.ok("Cliente Borrado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexsistente");
        }

    }

}
