package com.dgw.sgco.repositories.financeiro;

import com.dgw.sgco.domain.financeiro.Parcela;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ParcelaRepository
 */
@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {

}