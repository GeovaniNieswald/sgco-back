package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EnderecoRepository
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
