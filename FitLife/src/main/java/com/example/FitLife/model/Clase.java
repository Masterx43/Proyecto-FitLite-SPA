package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clase {
    private int idClase;
    private String nombre;
    private String descripcion;
    private Long capacidadMaxima;
    private String ubicacion;
    private Date fechaHora;
    private int entrenadorId;
}
