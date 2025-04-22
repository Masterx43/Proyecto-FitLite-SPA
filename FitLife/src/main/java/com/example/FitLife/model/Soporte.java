package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soporte {
    private int ticketId;
    private int usuarioId;
    private Date fechaCreacion;
    private String tipo;
    private String estado;
    private String descripcion;
}
