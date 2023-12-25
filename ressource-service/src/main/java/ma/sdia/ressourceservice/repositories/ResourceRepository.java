package ma.sdia.ressourceservice.repositories;

import ma.sdia.ressourceservice.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ResourceRepository extends JpaRepository<Ressource,Long> {
}
