package com.dgw.sgco.services.financeiro;

import java.util.Optional;

import com.dgw.sgco.domain.financeiro.Movimentacao;
import com.dgw.sgco.repositories.financeiro.MovimentacaoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MovimentacaoService
 */
@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repo;

    /**
     * Buscar Movimentação por id
     * 
     * @param id - Integer
     * @return Movimentacao
     */
    public Movimentacao find(Integer id) {
        Optional<Movimentacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
    }
}