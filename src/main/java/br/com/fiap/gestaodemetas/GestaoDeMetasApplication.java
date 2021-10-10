package br.com.fiap.gestaodemetas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.fiap.gestaodemetas.repository")
@ComponentScan("br.com.fiap.gestaodemetas.service")
public class GestaoDeMetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeMetasApplication.class, args);
	}

}
