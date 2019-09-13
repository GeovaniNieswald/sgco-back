package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Funcionario;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FuncionarioRepository
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {

}
