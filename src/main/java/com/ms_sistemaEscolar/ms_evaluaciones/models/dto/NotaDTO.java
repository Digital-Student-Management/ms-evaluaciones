package com.ms_sistemaEscolar.ms_evaluaciones.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotaDTO {

    private int id_nota;

    private Double valorCalif;

    private String formatoNota;

    @NotNull
    private int puntaje;

    @NotBlank
    private String observacion;

    @NotNull
    private int idEvaluacion;

    @NotNull
    private int idEstudiante;
}
