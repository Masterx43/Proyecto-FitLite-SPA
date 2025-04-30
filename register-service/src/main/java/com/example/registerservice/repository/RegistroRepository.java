package com.example.registerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registerservice.model.Cliente;

@Repository
public interface RegistroRepository extends JpaRepository<Cliente,Integer> {

}
