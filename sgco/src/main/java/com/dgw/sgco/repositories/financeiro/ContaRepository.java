package com.dgw.sgco.repositories.financeiro;

import com.dgw.sgco.domain.financeiro.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContaRepository
 */
@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
