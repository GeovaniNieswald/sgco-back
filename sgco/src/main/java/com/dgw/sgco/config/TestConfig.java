package com.dgw.sgco.config;

import java.text.ParseException;

import com.dgw.sgco.services.DBService;
import com.dgw.sgco.services.email.EmailService;
import com.dgw.sgco.services.email.MockEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TestConfig
 */
@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	/**
	 * Método para instanciar alguns dados
	 * 
	 * @return true
	 * @throws ParseException
	 */
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateDatabase(true);
		return true;
	}

	/**
	 * Método para obter uma implementação (MockEmailService) da interface EmailService
	 * 
	 * @return MockEmailService
	 */
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
