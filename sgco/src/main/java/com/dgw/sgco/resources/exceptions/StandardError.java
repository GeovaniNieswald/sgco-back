package com.dgw.sgco.resources.exceptions;

import java.io.Serializable;

/**
 * StandardError
 */
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private Long timestamp;

    /**
     * Erro Padrão
     * 
     * @param status    - Integer
     * @param msg       - String
     * @param timestamp - Long
     */
    public StandardError(Integer status, String msg, Long timestamp) {
        this.status = status;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}