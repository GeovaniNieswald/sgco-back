package com.dgw.sgco.services.financeiro;

import java.util.Optional;

import com.dgw.sgco.domain.financeiro.Parcela;
import com.dgw.sgco.repositories.financeiro.ParcelaRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ParcelaService
 */
@Service
public class ParcelaService {

    @Autowired
    private ParcelaRepository repo;

    /**
     * Buscar Parcela por id
     * 
     * @param id - Integer
     * @return Parcela
     */
    public Parcela find(Integer id) {
        Optional<Parcela> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Parcela.class.getName()));
    }
}