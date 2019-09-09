package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContatoRepository
 */
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
