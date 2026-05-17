package com.ms_sistemaEscolar.ms_evaluaciones.services;

import com.ms_sistemaEscolar.ms_evaluaciones.models.dto.NotaDTO;
import com.ms_sistemaEscolar.ms_evaluaciones.models.entity.Evaluacion;
import com.ms_sistemaEscolar.ms_evaluaciones.models.entity.Nota;
import com.ms_sistemaEscolar.ms_evaluaciones.repositories.EvaluacionRepository;
import com.ms_sistemaEscolar.ms_evaluaciones.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    // ───── Listar todas ─────────────────────────────────────────────────────
    public List<NotaDTO> listarTodos() {
        return notaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ───── Buscar por ID ─────────────────────────────────────────────────────
    public NotaDTO buscarPorId(int id) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nota no encontrada."));
        return toDTO(nota);
    }

    // ───── Guardar / Actualizar ───────────────────────────────────────────────
    public NotaDTO guardar(NotaDTO dto) {
        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "La Evaluación especificada no existe."));
        Nota nota = toEntity(dto, evaluacion);
        return toDTO(notaRepository.save(nota));
    }

    // ───── Eliminar ───────────────────────────────────────────────────────────
    public void eliminar(int id) {
        notaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nota no encontrada."));
        notaRepository.deleteById(id);
    }

    // ───── Mapeo Entity → DTO ─────────────────────────────────────────────────
    private NotaDTO toDTO(Nota n) {
        NotaDTO dto = new NotaDTO();
        dto.setId_nota(n.getId_nota());
        dto.setValorCalif(n.getValor_calif());
        dto.setFormatoNota(n.getFormato_nota());
        dto.setPuntaje(n.getPuntaje());
        dto.setObservacion(n.getObservacion());
        dto.setIdEvaluacion(n.getEvaluacion().getId_evaluacion());
        dto.setIdEstudiante(n.getId_estudiante());
        return dto;
    }

    // ───── Mapeo DTO → Entity ─────────────────────────────────────────────────
    private Nota toEntity(NotaDTO dto, Evaluacion evaluacion) {
        Nota n = new Nota();
        n.setId_nota(dto.getId_nota());
        n.setValor_calif(dto.getValorCalif() != null ? dto.getValorCalif() : 0.0);
        n.setFormato_nota(dto.getFormatoNota());
        n.setPuntaje(dto.getPuntaje());
        n.setObservacion(dto.getObservacion());
        n.setEvaluacion(evaluacion);
        n.setId_estudiante(dto.getIdEstudiante());
        return n;
    }
}
