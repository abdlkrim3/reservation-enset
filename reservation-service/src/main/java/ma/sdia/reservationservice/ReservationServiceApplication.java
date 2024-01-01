package ma.sdia.reservationservice;

import ma.sdia.reservationservice.entities.Personne;
import ma.sdia.reservationservice.entities.Reservation;
import ma.sdia.reservationservice.model.Ressource;
import ma.sdia.reservationservice.repositories.PersonneRepository;
import ma.sdia.reservationservice.repositories.ReservationRepository;
import ma.sdia.reservationservice.web.ResourceRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ReservationRepository reservationRepository, ResourceRestClient resourceRestClient, PersonneRepository personneRepository) {
		return args -> {
			Personne personne1=new Personne(UUID.randomUUID().toString(),"Abdelkarim","abdlkrim@gmail.com","Etudiant");
			Personne personne2=new Personne(UUID.randomUUID().toString(),"Agoujil","agoujil@gmail.com","Etudiant");
			personneRepository.save(personne1);
			personneRepository.save(personne2);

			List<Ressource>ressourceList=resourceRestClient.allRessource();

			personneRepository.findAll().forEach(p -> {
				Reservation reservation1 = Reservation.builder()
						.name("reservation1")
						.context("context1")
						.date(new Date())
						.duration(new Random().nextInt(2, 30))
						.ressourceId(ressourceList.get(0).getId())
						.personne(p)
						.personneId(p.getId())
						.build();
				Reservation reservation2 = Reservation.builder()
						.name("reservation2")
						.context("context2")
						.date(new Date())
						.duration(new Random().nextInt(2, 30))
						.ressourceId(ressourceList.get(1).getId())
						.personne(p)
						.personneId(p.getId())
						.build();
				reservationRepository.save(reservation1);
				reservationRepository.save(reservation2);
			});

		};

	}
}
