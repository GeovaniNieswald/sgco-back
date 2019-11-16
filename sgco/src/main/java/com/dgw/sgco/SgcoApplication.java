package com.dgw.sgco;

import java.util.List;

import com.dgw.sgco.config.FileStorageProperties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
@EnableConfigurationProperties({FileStorageProperties.class})
public class SgcoApplication implements CommandLineRunner, WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new SpecificationArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(SgcoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
