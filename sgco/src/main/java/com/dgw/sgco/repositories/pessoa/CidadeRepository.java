package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CidadeRepository
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}