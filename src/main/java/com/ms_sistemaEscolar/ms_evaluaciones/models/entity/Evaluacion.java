package com.ms_sistemaEscolar.ms_evaluaciones.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evaluacion;

    private String titulo_ev;

    private LocalDate fecha_aplicacion;

    private double porcentaje_pond;
}
