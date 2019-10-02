package com.dgw.sgco.services.email;

import com.dgw.sgco.domain.agendamento.Agendamento;

import org.springframework.mail.SimpleMailMessage;

/**
 * EmailService
 */
public interface EmailService {

    /**
     * Método para enviar uma notificação de agendamento
     * 
     * @param obj - Agendamento
     */
    void enviarNotificacaoAgendamento(Agendamento obj);

    /**
     * Método para enviar um email
     * 
     * @param msg - SimpleMailMessage
     */
    void sendEmail(SimpleMailMessage msg);

}
