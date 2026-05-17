package com.ms_sistemaEscolar.ms_evaluaciones.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nota;

    private double valor_calif;

    private String formato_nota;

    private int puntaje;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;
}
