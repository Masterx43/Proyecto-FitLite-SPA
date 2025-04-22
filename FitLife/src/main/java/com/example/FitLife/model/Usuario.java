package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private int usuarioId;
    private String pNombre;
    private String sNombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private Date fechaRegistro;

}
