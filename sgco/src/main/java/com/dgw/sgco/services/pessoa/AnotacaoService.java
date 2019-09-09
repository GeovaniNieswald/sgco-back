package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Anotacao;
import com.dgw.sgco.repositories.pessoa.AnotacaoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AnotacaoService
 */
@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository repo;

    /**
     * Buscar Anotação por id
     * 
     * @param id - Integer
     * @return Anotacao
     */
    public Anotacao find(Integer id) {
        Optional<Anotacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Anotacao.class.getName()));
    }

}
