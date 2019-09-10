package com.dgw.sgco.resources.financeiro;

import com.dgw.sgco.domain.financeiro.Parcela;
import com.dgw.sgco.services.financeiro.ParcelaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ParcelaResource
 */
@RestController
@RequestMapping(value = "/parcelas")
public class ParcelaResource {

    @Autowired
    private ParcelaService service;

    /**
     * Buscar Parcela por id
     * 
     * @param id - Integer
     * @return Parcela
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Parcela> find(@PathVariable Integer id) {
        Parcela obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
