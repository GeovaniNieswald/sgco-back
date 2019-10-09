package com.dgw.sgco.services.email;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * MockEmailService
 */
public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    /**
     * Implementação do método de envio de email, para testes utilizando LOG
     * 
     * @param msg - SimpleMailMessage
     */
    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Simulando envio de email...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }

    /**
     * Implementação do método de envio de email html, para testes utilizando LOG
     * 
     * @param msg - MimeMessage
     */
    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Simulando envio de email HTML...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }
}
