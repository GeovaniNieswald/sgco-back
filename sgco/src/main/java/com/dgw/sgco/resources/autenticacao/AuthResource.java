package com.dgw.sgco.resources.autenticacao;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.dgw.sgco.dto.autenticacao.EmailDTO;
import com.dgw.sgco.security.JWTUtil;
import com.dgw.sgco.security.UserSS;
import com.dgw.sgco.services.autenticacao.AuthService;
import com.dgw.sgco.services.autenticacao.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthResource
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    /**
     * Atualizar token
     * 
     * @param response
     * @return ResponseEntity
     */
    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);

        return ResponseEntity.noContent().build();
    }

    /**
     * Esqueci senha
     * 
     * @param response
     * @return ResponseEntity
     */
    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@RequestBody @Valid EmailDTO objDto) {
        authService.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }
}
