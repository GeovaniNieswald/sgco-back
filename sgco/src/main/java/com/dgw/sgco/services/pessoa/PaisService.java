package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Pais;
import com.dgw.sgco.repositories.pessoa.PaisRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PaisService
 */
@Service
public class PaisService {

    @Autowired
    private PaisRepository repo;

    /**
     * Buscar Pais por id
     * 
     * @param id - Integer
     * @return Pais
     */
    public Pais find(Integer id) {
        Optional<Pais> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
    }

}
