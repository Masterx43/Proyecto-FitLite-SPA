package com.example.perfilcliente_services.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.perfilcliente_services.model.Cliente;

public interface PerfilClienteRepository extends JpaRepository<Cliente,Integer> {
    Optional<Cliente>findByEmail(String email);
    boolean deleteByEmail(String email);
    

}
