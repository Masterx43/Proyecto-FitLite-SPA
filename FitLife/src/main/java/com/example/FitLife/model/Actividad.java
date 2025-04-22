package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
    private int actividadId;
    private int usuarioId;
    private int claseId;
    private Date fechaAsistencia;
    private String observaciones;
}
