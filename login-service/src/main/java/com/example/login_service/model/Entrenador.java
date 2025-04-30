package com.example.login_service.model;

import java.util.Date;
// hola
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entrenador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
