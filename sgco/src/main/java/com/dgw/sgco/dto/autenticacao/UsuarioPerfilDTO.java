package com.dgw.sgco.dto.autenticacao;

import java.io.Serializable;
import java.util.Date;

import com.dgw.sgco.dto.pessoa.ContatoDTO;
import com.dgw.sgco.dto.pessoa.EnderecoDTO;

/**
 * UsuarioPerfilDTO
 */
public class UsuarioPerfilDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String imagem;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private Date nascimento;
    private String crmCro;
    private String tipo;

    private EnderecoDTO endereco;
    private ContatoDTO contato;

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(String email, String imagem, String nome, String cpf, String rg, String sexo, Date nascimento, String crmCro, String tipo, EnderecoDTO endereco, ContatoDTO contato) {
        this.email = email;
        this.imagem = imagem;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.crmCro = crmCro;
        this.tipo = tipo;
        this.endereco = endereco;
        this.contato = contato;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCrmCro() {
        return crmCro;
    }

    public void setCrmCro(String crmCro) {
        this.crmCro = crmCro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public ContatoDTO getContato() {
        return contato;
    }

    public void setContato(ContatoDTO contato) {
        this.contato = contato;
    }

}
