package com.example.membresias_services.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Membresias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMembresia;

    @Column(nullable = false)
    private String NombreMebresia;

    @Column(nullable = false)
    private String DescripcionMembresia;

    @Column(nullable = false)
    private Integer PrecioMembresia;

    @Column(nullable = false)
    private Date DuracionDeMembresia;   

}
