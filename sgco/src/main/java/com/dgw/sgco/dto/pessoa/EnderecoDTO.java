package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;

import com.dgw.sgco.domain.pessoa.Endereco;

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
    private String cidade;
    private String estado;
    private String pais;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Integer id, String logradouro, String bairro, String numero, String cep, String complemento, String cidade, String estado, String pais) {
        this();
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public EnderecoDTO(Endereco endereco) {
        this();
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.bairro = endereco.getBairro();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.cidade = endereco.getCidade().getNome();
        this.estado = endereco.getCidade().getEstado().getNome() + " - " + endereco.getCidade().getEstado().getUf();
        this.pais = endereco.getCidade().getEstado().getPais().getNome() + " - " + endereco.getCidade().getEstado().getPais().getSigla();
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
