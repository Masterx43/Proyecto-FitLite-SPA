package com.example.FitLife.model;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class cliente extends Usuario{
    private int id;
    private ArrayList<Reservas> reservas;
    private ArrayList<Actividad> actividades;
    private ArrayList<Pago> pagos;
    private ArrayList<Resena> reseñas;
}
