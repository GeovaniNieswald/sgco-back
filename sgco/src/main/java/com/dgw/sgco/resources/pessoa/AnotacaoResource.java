package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Anotacao;
import com.dgw.sgco.services.pessoa.AnotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnotacaoResource
 */
@RestController
@RequestMapping(value = "/anotacoes")
public class AnotacaoResource {

    @Autowired
    private AnotacaoService service;

    /**
     * Buscar Anotação por id
     * 
     * @param id - Integer
     * @return Anotacao
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Anotacao> find(@PathVariable Integer id) {
        Anotacao obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
