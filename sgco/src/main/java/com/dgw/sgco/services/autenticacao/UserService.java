package com.dgw.sgco.services.autenticacao;

import com.dgw.sgco.security.UserSS;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * UserService
 */
public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception ex) {
            return null;
        }
    }
}
