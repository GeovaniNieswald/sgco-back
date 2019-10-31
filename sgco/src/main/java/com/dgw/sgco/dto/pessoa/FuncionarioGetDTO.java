package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.dgw.sgco.domain.enums.TipoFuncionario;
import com.dgw.sgco.domain.pessoa.Funcionario;

import org.hibernate.validator.constraints.Length;

/**
 * FuncionarioGetDTO
 */
public class FuncionarioGetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 60, message = "O tamanho deve ser entre 5 e 60 caracteres")
    private String nome;

    private String cpf;
    private String tipo;
    private String telefone;
    private boolean ativo;

    public FuncionarioGetDTO() {
    }

    /**
     * 
     * @param obj - Funcionario
     */
    public FuncionarioGetDTO(Funcionario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.tipo = TipoFuncionario.toEnum(obj.getTipo()).getDescricao();
        this.telefone = obj.getContato().getTelefone1();
        this.ativo = obj.isAtivo();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = TipoFuncionario.toEnum(tipo).getDescricao();
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
