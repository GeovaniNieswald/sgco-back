package com.dgw.sgco.repositories.agendamento;

import com.dgw.sgco.domain.agendamento.ProcedimentoAgendado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProcedimentoAgendadoRepository
 */
@Repository
public interface ProcedimentoAgendadoRepository extends JpaRepository<ProcedimentoAgendado, Integer> {

}
