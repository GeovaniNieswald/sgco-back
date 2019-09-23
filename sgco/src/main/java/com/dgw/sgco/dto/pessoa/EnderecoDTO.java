package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;

/**
 * EnderecoDTO
 */
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String complemento;
    private Integer idCidade;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Integer id, String logradouro, String bairro, String numero, String cep, String complemento, Integer idCidade) {
        this();
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.idCidade = idCidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

}
