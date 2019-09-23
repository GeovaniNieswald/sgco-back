package com.dgw.sgco.dto.autenticacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * UsuarioDTO
 */
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String login;
    private String senha;
    private boolean ativo;
    private String imagem;
    private List<Integer> permissoes = new ArrayList<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String login, String senha, boolean ativo, String imagem) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Integer> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Integer> permissoes) {
        this.permissoes = permissoes;
    }

}
