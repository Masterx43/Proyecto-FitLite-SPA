package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reserva {
    private int reservaId;
    private int idUsuario;
    private int claseId;
    private Date fechaReserva;
    private String estadoReserva;

}
