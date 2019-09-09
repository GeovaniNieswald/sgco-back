package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Pais;
import com.dgw.sgco.services.pessoa.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaisResource
 */
@RestController
@RequestMapping(value = "/paises")
public class PaisResource {

    @Autowired
    private PaisService service;

    /**
     * Buscar Pais por id
     * 
     * @param id - Integer
     * @return Pais
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Pais obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
