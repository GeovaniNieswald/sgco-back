package com.dgw.sgco.repositories.agendamento;

import com.dgw.sgco.domain.agendamento.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AgendamentoRepository
 */
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}