package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resena {
    private int resenaId;
    private int usuarioId;
    private int claseId;
    private String comentario;
    private int calificacion;
    private Date fechaResena;
}
