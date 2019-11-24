package com.dgw.sgco.dto.autenticacao;

import java.io.Serializable;

/**
 * AlterarImagemDTO
 */
public class AlterarImagemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String imagem;

    public AlterarImagemDTO() {
    }

    public AlterarImagemDTO(String email, String imagem) {
        this.email = email;
        this.imagem = imagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
