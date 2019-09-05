package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Endereco;
import com.dgw.sgco.repositories.pessoa.EnderecoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EnderecoService
 */
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repo;

    /**
     * Buscar Endereço por id
     * 
     * @param id - Integer
     * @return Endereco
     */
    public Endereco find(Integer id) {
        Optional<Endereco> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
    }

}