package com.dgw.sgco.domain.agendamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.dgw.sgco.domain.enums.StatusAgendamento;
import com.dgw.sgco.domain.financeiro.Movimentacao;
import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.domain.pessoa.Paciente;
import com.dgw.sgco.utils.JsonToMapConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Agendamento
 */
@Entity
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String anamnese;
    private String diagnostico;
    private String observacao;

    @Column(name = "receituario", columnDefinition = "VARCHAR") // Teste: VARCHAR Dev e Prod: JSON
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> receituario = new HashMap<>();

    @Column(name = "atestado", columnDefinition = "VARCHAR") // Teste: VARCHAR Dev e Prod: JSON
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> atestado = new HashMap<>();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "data_hora_inicio")
    private Date dataHoraInicio;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "data_hora_fim")
    private Date dataHoraFim;

    @Column(name = "cod_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    @JsonIgnoreProperties(value = {"anotacoes"})
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    @JsonIgnoreProperties(value = {"usuario"})
    private Funcionario funcionario;

    @JsonIgnore
    @OneToMany(mappedBy = "agendamento")
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.agendamento", cascade = CascadeType.ALL)
    private Set<ProcedimentoAgendado> procedimentos = new HashSet<>();

    public Agendamento() {
    }

    /**
     * Agendamento
     * 
     * @param id             - Integer
     * @param anamnese       - String
     * @param diagnostico    - String
     * @param dataHoraInicio - Date
     * @param dataHoraFim    - Date
     * @param observacao     - String
     * @param status         - StatusAgendamento
     * @param paciente       - Paciente
     * @param funcionario    - Funcionario
     */
    public Agendamento(Integer id, String anamnese, String diagnostico, Date dataHoraInicio, Date dataHoraFim, String observacao, StatusAgendamento status, Paciente paciente, Funcionario funcionario) {
        this();
        this.id = id;
        this.anamnese = anamnese;
        this.diagnostico = diagnostico;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacao = observacao;
        this.status = (status == null) ? null : status.getCod();
        this.paciente = paciente;
        this.funcionario = funcionario;
    }

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ProcedimentoAgendado pa : this.procedimentos) {
            total = total.add(pa.getSubTotal());
        }

        return total.setScale(2, RoundingMode.HALF_DOWN);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Map<String, Object> getreceituario() {
        return receituario;
    }

    public void setreceituario(Map<String, Object> receituario) {
        this.receituario = receituario;
    }

    public Map<String, Object> getAtestado() {
        return atestado;
    }

    public void setAtestado(Map<String, Object> atestado) {
        this.atestado = atestado;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusAgendamento getStatus() {
        return StatusAgendamento.toEnum(this.status);
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status.getCod();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Set<ProcedimentoAgendado> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(Set<ProcedimentoAgendado> procedimentos) {
        this.procedimentos = procedimentos;
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
        Agendamento other = (Agendamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        StringBuilder builder = new StringBuilder();

        builder.append("Agendamento número: ");
        builder.append(this.getId());
        builder.append(", Data início: ");
        builder.append(sdf.format(this.getDataHoraInicio()));
        builder.append(", Data fim: ");
        builder.append(sdf.format(this.getDataHoraFim()));
        builder.append(", Paciente: ");
        builder.append(this.getPaciente().getNome());
        builder.append(", Status agendamento: ");
        builder.append(this.getStatus().getDescricao());
        builder.append("\nDetalhes:\n");

        for (ProcedimentoAgendado pa : this.getProcedimentos()) {
            builder.append(pa.toString());
        }

        builder.append("Valor total: ");
        builder.append(nf.format(this.getValorTotal()));

        return builder.toString();
    }

}
