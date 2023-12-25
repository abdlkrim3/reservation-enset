package ma.sdia.ressourceservice.web;

import ma.sdia.ressourceservice.entities.Ressource;
import ma.sdia.ressourceservice.repositories.ResourceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RessourceRestController {
    ResourceRepository resourceRepository;
    public RessourceRestController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
    @GetMapping("/ressources")
    public List<Ressource> ressourceList(){
        return resourceRepository.findAll();
    }
    @GetMapping("/ressources/{id}")
    public Ressource resourceById(@PathVariable Long id){
        return resourceRepository.findById(id).get();
    }

}
