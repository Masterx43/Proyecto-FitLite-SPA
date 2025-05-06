package com.example.report_service.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reportes")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 20, max = 100)              // Java
    @Column(nullable = false, length = 100) // Base de datos
    private String titulo;

    @Size(min = 10, max = 1000)
    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column
    private Date fechaReporte;
}