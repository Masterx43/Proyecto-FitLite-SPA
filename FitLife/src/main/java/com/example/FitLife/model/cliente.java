package com.example.FitLife.model;

import java.util.ArrayList;

public class cliente extends Usuario{
    private Long id;
    private ArrayList<Reservas> reservas;
    private ArrayList<Actividad> actividades;
    private ArrayList<Pago> pagos;
    private ArrayList<Resena> reseñas;
}
