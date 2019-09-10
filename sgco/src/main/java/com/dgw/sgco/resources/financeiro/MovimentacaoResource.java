package com.dgw.sgco.resources.financeiro;

import com.dgw.sgco.domain.financeiro.Movimentacao;
import com.dgw.sgco.services.financeiro.MovimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MovimentacaoResource
 */
@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoResource {

    @Autowired
    private MovimentacaoService service;

    /**
     * Buscar Movimentação por id
     * 
     * @param id - Integer
     * @return Movimentacao
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movimentacao> find(@PathVariable Integer id) {
        Movimentacao obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
