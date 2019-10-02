package com.dgw.sgco.services.email;

import java.util.Date;

import com.dgw.sgco.domain.agendamento.Agendamento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 * AbstractEmailService
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    /**
     * Implementação do método para enviar uma notificação de agendamento
     * 
     * @param obj - Agendamento
     */
    @Override
    public void enviarNotificacaoAgendamento(Agendamento obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromAgendamento(obj);
        sendEmail(sm);
    }

    /**
     * Método para preparar o email com os dados do agendamento
     * 
     * @param obj - Agendamento
     * @return SimpleMailMessage
     */
    protected SimpleMailMessage prepareSimpleMailMessageFromAgendamento(Agendamento obj) {
        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(obj.getPaciente().getContato().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Agendamento realizado! Número: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());

        return sm;
    }
}
