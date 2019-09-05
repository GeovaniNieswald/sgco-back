package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Contato;
import com.dgw.sgco.services.pessoa.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ContatoResource
 */
@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    /**
     * Buscar Contato por id
     * 
     * @param id - Integer
     * @return Contato
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Contato obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}