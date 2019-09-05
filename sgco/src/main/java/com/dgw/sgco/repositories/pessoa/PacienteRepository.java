package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PacienteRepository
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}