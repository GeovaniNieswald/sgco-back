package com.dgw.sgco.repositories.agendamento;

import com.dgw.sgco.domain.agendamento.Procedimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProcedimentoRepository
 */
@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {

}