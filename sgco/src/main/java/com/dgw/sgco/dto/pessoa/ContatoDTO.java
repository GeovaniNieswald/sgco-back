package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;

/**
 * ContatoDTO
 */
public class ContatoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String email;
    private String telefone1;
    private String telefone2;

    public ContatoDTO() {
    }

    public ContatoDTO(Integer id, String email, String telefone1) {
        this();
        this.id = id;
        this.email = email;
        this.telefone1 = telefone1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
}
