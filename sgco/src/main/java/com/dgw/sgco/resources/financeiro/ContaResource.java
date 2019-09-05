package com.dgw.sgco.resources.financeiro;

import com.dgw.sgco.domain.financeiro.Conta;
import com.dgw.sgco.services.financeiro.ContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ContaResource
 */
@RestController
@RequestMapping(value = "/contas")
public class ContaResource {

    @Autowired
    private ContaService service;

    /**
     * Buscar Conta por id
     * 
     * @param id - Integer
     * @return Conta
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Conta obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}