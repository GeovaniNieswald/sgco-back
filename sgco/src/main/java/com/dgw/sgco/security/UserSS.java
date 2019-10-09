package com.dgw.sgco.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.dgw.sgco.domain.enums.Permissao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserSS
 */
public class UserSS implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    /**
     * 
     * @param id         - Integer
     * @param email      - String
     * @param senha      - String
     * @param permissoes - List<Permissao>
     */
    public UserSS(Integer id, String email, String senha, List<Permissao> permissoes) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.authorities = permissoes.stream().map(x -> new SimpleGrantedAuthority(x.getNomeInterno())).collect(Collectors.toList());
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Método para verificar se o usuário possui a permissão informada
     * 
     * @param permissao - Permissao
     * @return boolean
     */
    public boolean hasRole(Permissao permissao) {
        return this.getAuthorities().contains(new SimpleGrantedAuthority(permissao.getNomeInterno()));
    }
}
