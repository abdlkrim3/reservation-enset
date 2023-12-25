package ma.sdia.reservationservice;

import ma.sdia.reservationservice.entities.Reservation;
import ma.sdia.reservationservice.repositories.ReservationRepository;
import ma.sdia.reservationservice.web.ResourceRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ReservationRepository reservationRepository, ResourceRestClient resourceRestClient) {
		return args -> {
			resourceRestClient.allRessource().forEach(r -> {
				Reservation reservation1 = Reservation.builder()
						.name("reservation1")
						.context("context1")
						.date(new Date())
						.duration(new Random().nextInt(2, 30))
						.ressourceId(r.getId())
						.build();
				Reservation reservation2 = Reservation.builder()
						.name("reservation1")
						.context("context1")
						.date(new Date())
						.duration(new Random().nextInt(2, 30))
						.ressourceId(r.getId())
						.build();
				reservationRepository.save(reservation1);
				reservationRepository.save(reservation2);
			});


		};

	}
}
