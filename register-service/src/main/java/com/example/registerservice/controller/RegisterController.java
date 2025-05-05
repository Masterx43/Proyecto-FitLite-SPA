package com.example.registerservice.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.model.Cliente;
import com.example.registerservice.services.RegisterServicers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api-v1/register")
public class RegisterController {

    @Autowired
    private RegisterServicers registerServicers;
   
    @PostMapping("/agregarCliente")
    public ResponseEntity<Cliente> CrearCliente(@RequestBody Cliente cliente) {
        registerServicers.CrearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> ModificarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        try{

            Cliente cliente2 = registerServicers.findbyId(id);
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

            registerServicers.save(cliente2);
            return ResponseEntity.ok(cliente);


        }catch (Exception e) {
            return ResponseEntity.notFound().build() ;   
        }
    }


    @GetMapping("/ClientesTotales")
    public ResponseEntity<List<Cliente>> TotalClientes() {
        List<Cliente> clientes = registerServicers.obtenercliente();
        if(clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> EliminarCliente (@PathVariable Integer id){
        boolean eliminar = registerServicers.BorrarCliente(id);
        if(eliminar){
            return ResponseEntity.ok("Cliente Borrado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexsistente");
        }

    }
    




  
    
}
