package ma.sdia.reservationservice.web;

import ma.sdia.reservationservice.model.Ressource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("ressource-service")
public interface ResourceRestClient {
    @GetMapping("/ressources")
    public List<Ressource> allRessource();
    @GetMapping("/ressources/{id}")
    public Ressource findRessourceById(@PathVariable Long id);

}
