package com.dgw.sgco.domain.enums;

public enum StatusAgendamento {

    AGENDADO(0, "Agendado"), CONFIRMADO(1, "Confirmado"), CANCELADO(2, "Cancelado");

    private Integer cod;
    private String descricao;

    private StatusAgendamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static StatusAgendamento toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (StatusAgendamento x : StatusAgendamento.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
