package com.dgw.sgco.config;

// import java.text.ParseException;

// import com.dgw.sgco.services.DBService;
import com.dgw.sgco.services.email.EmailService;
import com.dgw.sgco.services.email.SmtpEmailService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * DevConfig
 */
@Configuration
@Profile("dev")
public class DevConfig {

    // @Autowired
    // private DBService dbService;

    // /**
    //  * Método para instanciar alguns dados
    //  *
    //  * @return true
    //  * @throws ParseException
    //  */
    // @Bean
    // public boolean instantiateDatabase() throws ParseException {
    //     dbService.instantiateDatabase(false);
    //     return true;
    // }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
