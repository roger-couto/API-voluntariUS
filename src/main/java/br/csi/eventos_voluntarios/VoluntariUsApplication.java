package br.csi.eventos_voluntarios;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API VoluntariUs",
				version = "1.0",
				description = "Sistema de gerenciamento de eventos voluntários",
				contact = @Contact(name = "Suporte", email = "suporte@voluntarius.com")
		)
)
@SpringBootApplication
public class VoluntariUsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VoluntariUsApplication.class, args);
	}
}

