package com.ms_sistemaEscolar.ms_evaluaciones.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EvaluacionDTO {

    private int id_evaluacion;

    @NotBlank
    private String tituloEv;

    @NotNull
    private LocalDate fechaAplicacion;

    private Double porcentajePond;

    @NotNull
    private int idAsignatura;
}
