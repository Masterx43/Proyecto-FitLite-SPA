package com.example.FitLife.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Membresia {
    private int idMembresia;
    private String NombreMembresia;
    private String DescripcionMembresia;
    private int PrecioMembresia;
    private Date DuracionDeMembresia;
}
