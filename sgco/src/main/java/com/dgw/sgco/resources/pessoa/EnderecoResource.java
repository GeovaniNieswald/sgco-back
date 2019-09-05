package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Endereco;
import com.dgw.sgco.services.pessoa.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * EnderecoResource
 */
@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    /**
     * Buscar Endereço por id
     * 
     * @param id - Integer
     * @return Endereco
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Endereco obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}