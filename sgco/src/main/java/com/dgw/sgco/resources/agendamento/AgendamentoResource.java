package com.dgw.sgco.resources.agendamento;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.services.agendamento.AgendamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AgendamentoResource
 */
@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService service;

    /**
     * Buscar Agendamento por id
     * 
     * @param id - Integer
     * @return Agendamento
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agendamento> find(@PathVariable Integer id) {
        Agendamento obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
