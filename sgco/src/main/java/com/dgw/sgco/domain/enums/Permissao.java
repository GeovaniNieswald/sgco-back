package com.dgw.sgco.domain.enums;

/**
 * Permissao
 */
public enum Permissao {

    DESENVOLVEDOR(0, "Desenvolvedor"), ADMINISTRADOR(1, "Administrador"), SECRETARIA(2, "Secretária"),
    DENTISTA(3, "Dentista");

    private Integer cod;
    private String descricao;

    /**
     * ENUM Permissão
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private Permissao(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static Permissao toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (Permissao x : Permissao.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }

}