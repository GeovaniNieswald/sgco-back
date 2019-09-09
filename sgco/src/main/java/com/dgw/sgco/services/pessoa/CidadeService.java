package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.repositories.pessoa.CidadeRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CidadeService
 */
@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    /**
     * Buscar Cidade por id
     * 
     * @param id - Integer
     * @return Cidade
     */
    public Cidade find(Integer id) {
        Optional<Cidade> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
    }

}
