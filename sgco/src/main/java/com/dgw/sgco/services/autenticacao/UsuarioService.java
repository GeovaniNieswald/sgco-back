package com.dgw.sgco.services.autenticacao;

import java.util.Optional;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    /**
     * Buscar Usuário por id
     * 
     * @param id - Integer
     * @return Usuário
     */
    public Usuario find(Integer id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }
}
