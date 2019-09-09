package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FuncionarioService
 */
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    /**
     * Buscar Funcionário por id
     * 
     * @param id - Integer
     * @return Funcionario
     */
    public Funcionario find(Integer id) {
        Optional<Funcionario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
    }

}
