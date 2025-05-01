package com.example.membresias_services.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.membresias_services.model.Membresias;
import com.example.membresias_services.services.MembresiaServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api-v1/Membresias")
public class ServicesController {



    @Autowired 
    private MembresiaServices membresiaServices;
    



    @PostMapping("/agregarMembresias")
    public ResponseEntity<Membresias> CrearMembresia(@RequestBody Membresias membresias) {
            membresiaServices.AgregarMembresia(membresias);
        return ResponseEntity.status(HttpStatus.CREATED).body(membresias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Membresias>> ObtenerMembresia() {

        List<Membresias> membresias = membresiaServices.ObtenerMembresia();
        if (membresias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(membresias);
    }

    @GetMapping("/MembresiasTotales")
    public ResponseEntity<List<Membresias>> ObtenerMembresiaTotales() {
        List<Membresias> membresias = membresiaServices.ObtenerMembresia();
        if(membresias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(membresias);
    }
    


    
    @PutMapping("/{id}")
    public ResponseEntity<Membresias>ActualizarMembresias(@PathVariable Integer id, @RequestBody Membresias membresias) {
    
        try{
            Membresias membresias2 = membresiaServices.findbyId(id);
            membresias2.setIdMembresia(id);
            membresias2.setNombreMebresia(membresias.getNombreMebresia());
            membresias2.setDescripcionMembresia(membresias.getDescripcionMembresia());
            membresias2.setPrecioMembresia(membresias.getPrecioMembresia());
            membresias2.setDuracionDeMembresia(membresias.getDuracionDeMembresia());

            membresiaServices.save(membresias2);
            return ResponseEntity.ok(membresias);

        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<String> EliminarMembresia(@PathVariable Integer id){
        boolean eliminar = membresiaServices.BorrarMembresias(id);
        if(eliminar){
            return ResponseEntity.ok("Membresia Borrada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membresia Inexistente");
        }
    }
    

    
    


}
