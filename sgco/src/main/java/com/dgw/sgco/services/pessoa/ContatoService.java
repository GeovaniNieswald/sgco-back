package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Contato;
import com.dgw.sgco.repositories.pessoa.ContatoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContatoService
 */
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repo;

    /**
     * Buscar Contato por id
     * 
     * @param id - Integer
     * @return Contato
     */
    public Contato find(Integer id) {
        Optional<Contato> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Contato.class.getName()));
    }

}
