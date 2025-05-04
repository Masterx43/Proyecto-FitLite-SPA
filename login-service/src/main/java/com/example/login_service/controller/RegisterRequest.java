package com.example.login_service.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Integer clienteId;
    private String pnombre;
    private String snombre;
    private String appaterno;
    private String apmaterno;
    private Integer edad;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private Date fechaRegistro;
}
