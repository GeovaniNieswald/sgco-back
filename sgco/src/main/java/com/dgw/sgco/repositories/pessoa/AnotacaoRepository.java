package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Anotacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AnotacaoRepository
 */
@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Integer> {

}
