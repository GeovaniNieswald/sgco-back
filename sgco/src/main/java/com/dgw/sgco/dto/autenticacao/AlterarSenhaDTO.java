package com.dgw.sgco.dto.autenticacao;

import java.io.Serializable;

/**
 * AlterarSenhaDTO
 */
public class AlterarSenhaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;

    private String nova;
    private String confirmacao;
    private String antiga;

    public AlterarSenhaDTO() {
    }

    public AlterarSenhaDTO(String email, String nova, String confirmacao, String antiga) {
        this.email = email;
        this.nova = nova;
        this.confirmacao = confirmacao;
        this.antiga = antiga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNova() {
        return nova;
    }

    public void setNova(String nova) {
        this.nova = nova;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }

    public String getAntiga() {
        return antiga;
    }

    public void setAntiga(String antiga) {
        this.antiga = antiga;
    }

}
