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

    /**
     * Método para buscar um Funcionário pelo id do seu usuário
     * 
     * @param idUsuario - Integer
     * @return Funcionario
     */
    public Funcionario findByUsuarioId(Integer idUsuario);

}
