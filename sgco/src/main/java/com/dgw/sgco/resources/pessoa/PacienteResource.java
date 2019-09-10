package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Paciente;
import com.dgw.sgco.services.pessoa.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PacienteResource
 */
@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {

    @Autowired
    private PacienteService service;

    /**
     * Buscar Paciente por id
     * 
     * @param id - Integer
     * @return Paciente
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Paciente> find(@PathVariable Integer id) {
        Paciente obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
