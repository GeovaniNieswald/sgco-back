package com.dgw.sgco.repositories.financeiro;

import com.dgw.sgco.domain.financeiro.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MovimentacaoRepository
 */
@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}