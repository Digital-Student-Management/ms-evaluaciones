package com.ms_sistemaEscolar.ms_evaluaciones.services;

import com.ms_sistemaEscolar.ms_evaluaciones.models.dto.EvaluacionDTO;
import com.ms_sistemaEscolar.ms_evaluaciones.models.entity.Evaluacion;
import com.ms_sistemaEscolar.ms_evaluaciones.repositories.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    // ───── Listar todas ─────────────────────────────────────────────────────
    public List<EvaluacionDTO> listarTodos() {
        return evaluacionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ───── Buscar por ID ─────────────────────────────────────────────────────
    public EvaluacionDTO buscarPorId(int id) {
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Evaluación no encontrada."));
        return toDTO(evaluacion);
    }

    // ───── Guardar / Actualizar ───────────────────────────────────────────────
    public EvaluacionDTO guardar(EvaluacionDTO dto) {
        Evaluacion evaluacion = toEntity(dto);
        return toDTO(evaluacionRepository.save(evaluacion));
    }

    // ───── Eliminar ───────────────────────────────────────────────────────────
    public void eliminar(int id) {
        evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Evaluación no encontrada."));
        evaluacionRepository.deleteById(id);
    }

    // ───── Mapeo Entity → DTO ─────────────────────────────────────────────────
    private EvaluacionDTO toDTO(Evaluacion e) {
        EvaluacionDTO dto = new EvaluacionDTO();
        dto.setId_evaluacion(e.getId_evaluacion());
        dto.setTituloEv(e.getTitulo_ev());
        dto.setFechaAplicacion(e.getFecha_aplicacion());
        dto.setPorcentajePond(e.getPorcentaje_pond());
        dto.setIdAsignatura(e.getId_asignatura());
        return dto;
    }

    // ───── Mapeo DTO → Entity ─────────────────────────────────────────────────
    private Evaluacion toEntity(EvaluacionDTO dto) {
        Evaluacion e = new Evaluacion();
        e.setId_evaluacion(dto.getId_evaluacion());
        e.setTitulo_ev(dto.getTituloEv());
        e.setFecha_aplicacion(dto.getFechaAplicacion());
        e.setPorcentaje_pond(dto.getPorcentajePond() != null ? dto.getPorcentajePond() : 0.0);
        e.setId_asignatura(dto.getIdAsignatura());
        return e;
    }
}
