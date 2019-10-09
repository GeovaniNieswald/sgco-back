package com.dgw.sgco.services.email;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * SmtpEmailService
 */
public class SmtpEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    /**
     * Implementação do método de envio de email, utilizando SMPT
     * 
     * @param msg - SimpleMailMessage
     */
    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Enviando email...");
        mailSender.send(msg);
        LOG.info("Email enviado");
    }

    /**
     * Implementação do método de envio de email html, utilizando SMPT
     * 
     * @param msg - MimeMessage
     */
    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Enviando email html...");
        javaMailSender.send(msg);
        LOG.info("Email enviado");
    }
}
