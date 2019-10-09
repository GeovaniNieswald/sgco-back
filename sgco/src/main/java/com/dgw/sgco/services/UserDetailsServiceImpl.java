package com.dgw.sgco.services;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsServiceImpl
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = repo.findByLogin(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(user.getId(), user.getLogin(), user.getSenha(), user.getPermissoes());
    }
}
