package ma.sdia.reservationservice.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.sdia.ressourceservice.entities.Ressource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.rest.core.mapping.ResourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RESSOURCE-SERVICE")
public interface ResourceRestClient {
    @GetMapping("/ressources")
    @CircuitBreaker(name = "ressourceService", fallbackMethod = "getAllRessources")
    public List<Ressource> allRessource();
    @GetMapping("/ressources/{id}")
    @CircuitBreaker(name = "ressource-service", fallbackMethod = "getDefaultRessource")
    public Ressource findRessourceById(@PathVariable Long id);

    default Ressource getDefaultCustomer(Long id, Exception exception){
        Ressource ressource=new Ressource();
        ressource.setId(id);
        ressource.setName("Ressource x");
        return ressource ;
    }
    default List<Ressource> getAllRessources(Exception exception){
        return List.of();
    }
}
