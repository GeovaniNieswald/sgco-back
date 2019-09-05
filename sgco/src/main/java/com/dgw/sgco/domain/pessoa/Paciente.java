package com.dgw.sgco.domain.pessoa;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dgw.sgco.utils.JsonToMapConverter;

/**
 * Paciente
 */
@Entity
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private String sexo;
    private Date nascimento;

    @Column(name = "odontograma", columnDefinition = "varchar") // Alterar para JSON quando utilizar no mysql
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> odontograma = new HashMap<>();

    @OneToOne
    @JoinColumn(name = "id_contato")
    private Contato contato;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Paciente() {
    }

    /**
     * Paciente
     * 
     * @param id         - Integer
     * @param nome       - String
     * @param cpf        - String
     * @param sexo       - String
     * @param nascimento - Date
     * @param contato    - Contato
     * @param endereco   - Endereco
     */
    public Paciente(Integer id, String nome, String cpf, String sexo, Date nascimento, Contato contato,
            Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.contato = contato;
        this.endereco = endereco;
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

    public Map<String, Object> getOdontograma() {
        return odontograma;
    }

    public void setOdontograma(Map<String, Object> odontograma) {
        this.odontograma = odontograma;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        Paciente other = (Paciente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}