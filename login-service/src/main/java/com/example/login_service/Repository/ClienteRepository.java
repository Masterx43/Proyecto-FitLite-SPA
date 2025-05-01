package com.example.login_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login_service.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    Optional<Boolean>findByEmail(String email);
}
