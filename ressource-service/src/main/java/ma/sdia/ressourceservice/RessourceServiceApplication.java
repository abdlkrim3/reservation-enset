package ma.sdia.ressourceservice;

import ma.sdia.ressourceservice.entities.Ressource;
import ma.sdia.ressourceservice.enums.ResourceType;
import ma.sdia.ressourceservice.repositories.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RessourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RessourceServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ResourceRepository resourceRepository){
		return args -> {

			List<Ressource> customerList=List.of(
					Ressource.builder()
							.name("Resource1")
							.type(ResourceType.MATERIEL_INFO)
							.build(),
					Ressource.builder()
							.name("Resource2")
							.type(ResourceType.MATERIEL_AUDIO_VISUEL)
							.build()
			);
			resourceRepository.saveAll(customerList);
		};
	}

}
