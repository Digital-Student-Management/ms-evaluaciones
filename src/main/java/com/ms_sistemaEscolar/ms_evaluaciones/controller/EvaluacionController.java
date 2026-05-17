package com.ms_sistemaEscolar.ms_evaluaciones.controller;

import com.ms_sistemaEscolar.ms_evaluaciones.models.dto.EvaluacionDTO;
import com.ms_sistemaEscolar.ms_evaluaciones.services.EvaluacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public List<EvaluacionDTO> listarTodos() {
        return evaluacionService.listarTodos();
    }

    @GetMapping("/{id}")
    public EvaluacionDTO buscarPorId(@PathVariable int id) {
        return evaluacionService.buscarPorId(id);
    }

    @PostMapping
    public EvaluacionDTO guardar(@Valid @RequestBody EvaluacionDTO dto) {
        return evaluacionService.guardar(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        evaluacionService.eliminar(id);
    }
}
