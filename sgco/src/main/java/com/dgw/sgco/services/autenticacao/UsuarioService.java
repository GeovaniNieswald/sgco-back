package com.dgw.sgco.services.autenticacao;

import java.util.Optional;

import javax.transaction.Transactional;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
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
    @Autowired
    private FuncionarioRepository funcionarioRepo;

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

    /**
     * Excluir um Usuário pelo id
     * 
     * @param id - Integer
     */
    @Transactional
    public void delete(Integer id) {
        find(id);

        Funcionario funcionario = this.funcionarioRepo.findByUsuarioId(id);

        if (funcionario != null) {
            funcionario.setUsuario(null);
        }

        repo.deleteById(id);
    }
}
