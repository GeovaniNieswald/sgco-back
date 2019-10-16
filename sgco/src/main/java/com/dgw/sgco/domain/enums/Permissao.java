package com.dgw.sgco.domain.enums;

/**
 * Permissao
 */
public enum Permissao {

    ADMINISTRADOR(1, "ROLE_ADMIN", "Administrador"), SECRETARIA(2, "ROLE_SECR", "Secretária"), DENTISTA(3, "ROLE_DENT", "Dentista");

    private Integer cod;
    private String nomeInterno;
    private String descricao;

    /**
     * ENUM Permissão
     * 
     * @param cod         - Integer
     * @param nomeInterno - String
     * @param descricao   - String
     */
    private Permissao(Integer cod, String nomeInterno, String descricao) {
        this.cod = cod;
        this.nomeInterno = nomeInterno;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getNomeInterno() {
        return this.nomeInterno;
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
