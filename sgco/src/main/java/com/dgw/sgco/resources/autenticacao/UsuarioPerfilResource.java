package com.dgw.sgco.resources.autenticacao;

import com.dgw.sgco.dto.autenticacao.UsuarioPerfilDTO;
import com.dgw.sgco.services.autenticacao.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UsuarioPerfilResource
 */
@RestController
@RequestMapping(value = "/perfil")
public class UsuarioPerfilResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioPerfilDTO> find(@PathVariable String email) {
        UsuarioPerfilDTO obj = service.findPerfil(email);

        return ResponseEntity.ok().body(obj);
    }
    
}