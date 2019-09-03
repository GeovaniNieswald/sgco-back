package com.dgw.sgco.resources.autenticacao;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.services.autenticacao.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UsuarioResource
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    
    @Autowired
    private UsuarioService service;

    /**
     * Buscar Usuario por id
     * 
     * @param id - Integer
     * @return Usuario
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Usuario obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}