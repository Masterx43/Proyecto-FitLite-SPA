package com.example.report_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.report_service.model.Reporte;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer>{
}
