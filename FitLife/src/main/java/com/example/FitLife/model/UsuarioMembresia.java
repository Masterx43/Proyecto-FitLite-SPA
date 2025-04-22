package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioMembresia {
    private int idUsuarioMembresia;
    private int usuarioId;
    private int membresiaId;
    private Date fechaInicio;
    private Date fechaFin;
}
