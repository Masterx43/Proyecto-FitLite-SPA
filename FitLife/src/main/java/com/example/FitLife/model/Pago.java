package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
    private int pagoId;
    private int usuarioId;
    private int monto;
    private Date fechaPago;
    private String metodoPago;
    private String detalle;
    private int membresiaId;
}