package com.dgw.sgco.dto.pessoa;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.dto.autenticacao.UsuarioDTO;
import com.dgw.sgco.services.validation.FuncionarioOperation;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 * FuncionarioDTO
 */
@FuncionarioOperation
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 60, message = "O tamanho deve ser entre 5 e 60 caracteres")
    private String nome;

    @CPF
    private String cpf;
    
    private String rg;
    private String sexo;
    private boolean ativo;
    private String nascimento;
    private Integer tipo;
    private String corAgenda;
    private String crmCro;

    private EnderecoDTO endereco;

    private ContatoDTO contato;

    private UsuarioDTO usuario;

    public FuncionarioDTO() {
    }

    /**
     * 
     * @param obj - Funcionario
     */
    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.rg = obj.getRg();
        this.sexo = obj.getSexo();
        this.ativo = obj.isAtivo();
        this.nascimento = sdf.format(obj.getNascimento());
        this.tipo = obj.getTipo().getCod();
        this.corAgenda = obj.getCorAgenda();
        this.crmCro = obj.getCrmCro();
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
