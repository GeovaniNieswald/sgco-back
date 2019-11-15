package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;

import com.dgw.sgco.domain.pessoa.Pais;

/**
 * PaisDTO
 */
public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public PaisDTO() {

    }

    public PaisDTO(Pais obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
