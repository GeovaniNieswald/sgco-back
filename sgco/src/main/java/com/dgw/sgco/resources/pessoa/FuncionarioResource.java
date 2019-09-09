package com.dgw.sgco.resources.pessoa;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.services.pessoa.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FuncionarioResource
 */
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    /**
     * Buscar Funcionário por id
     * 
     * @param id - Integer
     * @return Funcionario
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Funcionario obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
