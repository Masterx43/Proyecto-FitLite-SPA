package com.example.paymentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentManager.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
    List<Pago> findByIdUsuario(int idUsuario);
}
