package com.dgw.sgco.domain.pessoa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dgw.sgco.domain.enums.TipoFuncionario;

/**
 * Funcionario
 */
@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private Date nascimento;
    private boolean ativo;
    private Integer tipo;

    @Column(name = "cor_agenda")
    private String corAgenda;

    @Column(name = "crm_cro")
    private String crmCro;

    public Funcionario() {
    }

    /**
     * Funcionário
     * 
     * @param id         - Integer
     * @param nome       - String
     * @param cpf        - String
     * @param rg         - String
     * @param sexo       - String
     * @param nascimento - Date
     * @param ativo      - boolean
     * @param tipo       - Integer
     * @param corAgenda  - String
     * @param crmCro     - String
     */
    public Funcionario(Integer id, String nome, String cpf, String rg, String sexo, Date nascimento, boolean ativo,
            Integer tipo, String corAgenda, String crmCro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.ativo = ativo;
        this.tipo = tipo;
        this.corAgenda = corAgenda;
        this.crmCro = crmCro;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoFuncionario getTipo() {
        return TipoFuncionario.toEnum(this.tipo);
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo.getCod();
    }

    public String getCorAgenda() {
        return corAgenda;
    }

    public void setCorAgenda(String corAgenda) {
        this.corAgenda = corAgenda;
    }

    public String getCrmCro() {
        return crmCro;
    }

    public void setCrmCro(String crmCro) {
        this.crmCro = crmCro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}