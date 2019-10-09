package com.dgw.sgco.repositories.autenticacao;

import com.dgw.sgco.domain.autenticacao.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Método para buscar um Usuário pelo seu login (Email)
     * 
     * @param email - String
     * @return Usuario
     */
    @Transactional(readOnly = true)
    public Usuario findByLogin(String email);

}
