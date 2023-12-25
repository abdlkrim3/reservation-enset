package ma.sdia.reservationservice.repositories;

import ma.sdia.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
