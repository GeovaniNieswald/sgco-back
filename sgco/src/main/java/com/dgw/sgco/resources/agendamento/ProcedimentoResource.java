package com.dgw.sgco.resources.agendamento;

import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.services.agendamento.ProcedimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProcedimentoResource
 */
@RestController
@RequestMapping(value = "/procedimentos")
public class ProcedimentoResource {

    @Autowired
    private ProcedimentoService service;

    /**
     * Buscar Procedimento por id
     * 
     * @param id - Integer
     * @return Procedimento
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Procedimento obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }
}
