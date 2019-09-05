package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.services.pessoa.CidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CidadeResource
 */
@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService service;

    /**
     * Buscar Cidade por id
     * 
     * @param id - Integer
     * @return Cidade
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Cidade obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}