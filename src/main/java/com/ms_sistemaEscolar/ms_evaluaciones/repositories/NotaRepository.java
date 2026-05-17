package com.ms_sistemaEscolar.ms_evaluaciones.repositories;

import com.ms_sistemaEscolar.ms_evaluaciones.models.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
