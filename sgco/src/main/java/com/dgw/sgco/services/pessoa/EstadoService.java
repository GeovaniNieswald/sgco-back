package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.repositories.pessoa.EstadoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EstadoService
 */
@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    /**
     * Buscar Estado por id
     * 
     * @param id - Integer
     * @return Estado
     */
    public Estado find(Integer id) {
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
    }

}