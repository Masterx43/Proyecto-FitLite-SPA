package com.example.login_service.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
    private int entrenadorId;
    private String pnombre;
    private String snombre;
    private String appaterno;
    private String apmaterno;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private Date fechaRegistro;
    private String especializacion;
    private boolean disponibilidad;
    private Date horario;
}
