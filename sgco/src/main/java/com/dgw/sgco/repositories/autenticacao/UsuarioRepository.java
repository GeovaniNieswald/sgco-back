package com.dgw.sgco.repositories.autenticacao;

import com.dgw.sgco.domain.autenticacao.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}