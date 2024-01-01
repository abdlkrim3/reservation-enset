package ma.sdia.reservationservice.repositories;

import ma.sdia.reservationservice.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,String> {
}
