package com.dgw.sgco.domain.autenticacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Usuario
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String senha;
    private boolean ativo;
    private String imagem;

    @ElementCollection(targetClass = Permissao.class)
    @JoinTable(name = "permissao", joinColumns = @JoinColumn(name = "id_usuario"))
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cod_permissao")
    private List<Permissao> permissoes = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Funcionario funcionario;

    public Usuario() {
    }

    /**
     * Usuário
     * 
     * @param id     - Integer
     * @param login  - String
     * @param senha  - String
     * @param ativo  - boolean
     * @param imagem - String
     */
    public Usuario(Integer id, String login, String senha, boolean ativo, String imagem) {
        this();
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
