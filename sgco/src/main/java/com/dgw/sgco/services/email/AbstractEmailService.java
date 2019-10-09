package com.dgw.sgco.services.email;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.autenticacao.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * AbstractEmailService
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Implementação do método para enviar uma notificação de agendamento com texto puro
     * 
     * @param obj - Agendamento
     */
    @Override
    public void enviarNotificacaoAgendamento(Agendamento obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromAgendamento(obj);
        sendEmail(sm);
    }

    /**
     * Implementação do método para enviar uma notificação de agendamento com HTML
     * 
     * @param obj - Agendamento
     */
    @Override
    public void enviarNotificacaoAgendamentoHtml(Agendamento obj) {
        try {
            MimeMessage mm = prepareMimeMessageFromAgendamento(obj);
            sendHtmlEmail(mm);
        } catch (MessagingException ex) {
            enviarNotificacaoAgendamento(obj);
        }
    }

    /**
     * Implementação do método para enviar um email com a nova senha
     * 
     * @param user    - Usuario
     * @param newPass - String
     */
    @Override
    public void sendNewPasswordEmail(Usuario user, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(user, newPass);
        sendEmail(sm);
    }

    /**
     * Método para preparar o email (texto puro) com os dados do agendamento
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

    /**
     * Método para preparar o email (HTML) com os dados do agendamento
     * 
     * @param obj - Agendamento
     * @return MimeMessage
     * @throws MessagingException
     */
    protected MimeMessage prepareMimeMessageFromAgendamento(Agendamento obj) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

        mmh.setTo(obj.getPaciente().getContato().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Agendamento realizado! Número: " + obj.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateAgendamento(obj), true);

        return mimeMessage;
    }

    /**
     * Método para criar html a partir de um template passando o Agendamento
     * 
     * @param obj - Agendamento
     * @return String (html)
     */
    protected String htmlFromTemplateAgendamento(Agendamento obj) {
        Context context = new Context();
        context.setVariable("agendamento", obj);

        return templateEngine.process("email/confirmacaoAgendamento", context);
    }

    /**
     * Método para preparar o email com os dados da nova senha
     * 
     * @param user    - Usuario
     * @param newPass - String
     * @return SimpleMailMessage
     */
    protected SimpleMailMessage prepareNewPasswordEmail(Usuario user, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(user.getLogin());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);

        return sm;
    }
}
