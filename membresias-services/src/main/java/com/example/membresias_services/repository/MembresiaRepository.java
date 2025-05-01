package com.example.membresias_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.membresias_services.model.Membresias;

public interface MembresiaRepository extends JpaRepository<Membresias,Integer> {

}
