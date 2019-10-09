package com.dgw.sgco.services.email;

import javax.mail.internet.MimeMessage;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.autenticacao.Usuario;

import org.springframework.mail.SimpleMailMessage;

/**
 * EmailService
 */
public interface EmailService {

    /**
     * Método para enviar uma notificação de agendamento com texto puro
     * 
     * @param obj - Agendamento
     */
    void enviarNotificacaoAgendamento(Agendamento obj);

    /**
     * Método para enviar um email com texto puro
     * 
     * @param msg - SimpleMailMessage
     */
    void sendEmail(SimpleMailMessage msg);

    /**
     * Método para enviar uma notificação de agendamento com HTML
     * 
     * @param obj - Agendamento
     */
    void enviarNotificacaoAgendamentoHtml(Agendamento obj);

    /**
     * Método para enviar um email com HTML
     * 
     * @param msg - MimeMessage
     */
    void sendHtmlEmail(MimeMessage msg);

    /**
     * Método para enviar um email com a nova senha gerada
     * 
     * @param user    - Usuario
     * @param newPass - String
     */
    void sendNewPasswordEmail(Usuario user, String newPass);
}
