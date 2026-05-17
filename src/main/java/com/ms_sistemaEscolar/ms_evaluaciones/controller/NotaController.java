package com.ms_sistemaEscolar.ms_evaluaciones.controller;

import com.ms_sistemaEscolar.ms_evaluaciones.models.dto.NotaDTO;
import com.ms_sistemaEscolar.ms_evaluaciones.services.NotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<NotaDTO> listarTodos() {
        return notaService.listarTodos();
    }

    @GetMapping("/{id}")
    public NotaDTO buscarPorId(@PathVariable int id) {
        return notaService.buscarPorId(id);
    }

    @PostMapping
    public NotaDTO guardar(@Valid @RequestBody NotaDTO dto) {
        return notaService.guardar(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        notaService.eliminar(id);
    }
}
