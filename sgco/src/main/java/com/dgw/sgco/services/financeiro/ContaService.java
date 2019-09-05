package com.dgw.sgco.services.financeiro;

import java.util.Optional;

import com.dgw.sgco.domain.financeiro.Conta;
import com.dgw.sgco.repositories.financeiro.ContaRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContaService
 */
@Service
public class ContaService {

    @Autowired
    private ContaRepository repo;

    /**
     * Buscar Conta por id
     * 
     * @param id - Integer
     * @return Conta
     */
    public Conta find(Integer id) {
        Optional<Conta> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
    }
}