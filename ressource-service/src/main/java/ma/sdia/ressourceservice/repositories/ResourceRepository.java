package ma.sdia.ressourceservice.repositories;

import ma.sdia.ressourceservice.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Ressource,Long> {
}
