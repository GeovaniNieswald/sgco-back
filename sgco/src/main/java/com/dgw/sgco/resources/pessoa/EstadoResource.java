package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.services.pessoa.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * EstadoResource
 */
@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    /**
     * Buscar Estado por id
     * 
     * @param id - Integer
     * @return Estado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Estado> find(@PathVariable Integer id) {
        Estado obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
