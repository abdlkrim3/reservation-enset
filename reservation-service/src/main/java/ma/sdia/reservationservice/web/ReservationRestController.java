package ma.sdia.reservationservice.web;

import ma.sdia.reservationservice.entities.Personne;
import ma.sdia.reservationservice.entities.Reservation;
import ma.sdia.reservationservice.model.Ressource;
import ma.sdia.reservationservice.repositories.PersonneRepository;
import ma.sdia.reservationservice.repositories.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class ReservationRestController {
    private ReservationRepository reservationRepository;
    private ResourceRestClient resourceRestClient;
    private PersonneRepository personneRepository;
    public ReservationRestController(ReservationRepository reservationRepository, ResourceRestClient resourceRestClient, PersonneRepository personneRepository) {
        this.reservationRepository = reservationRepository;
        this.resourceRestClient = resourceRestClient;
        this.personneRepository = personneRepository;
    }

    @GetMapping("/reservations")
    public List<Reservation> reservationList(){
        List<Reservation> reservationList = reservationRepository.findAll();
        reservationList.forEach(rserv->{
            rserv.setPersonne( personneRepository.findById(rserv.getPersonneId()).get());
            rserv.setRessource(resourceRestClient.findRessourceById(rserv.getRessourceId()));
        });
        return reservationList;
    }
    @GetMapping("/reservation/{id}")
    public Reservation reservationById(@PathVariable Long id){
        Reservation reservation= reservationRepository.findById(id).get();
        Ressource ressource=resourceRestClient.findRessourceById(reservation.getRessourceId());
        reservation.setRessource(ressource);
        return reservation;
    }
    @GetMapping("/users")
    public List<Personne> personneList(){
        List<Personne> personneList=personneRepository.findAll();
        return personneList;
    }
    @GetMapping("/users/{id}")
    public Personne personneById(@PathVariable String id) {
        Personne p = personneRepository.findById(id).get();
        return p;
    }

    @PostMapping("/reserve")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        System.out.println("--------------------------------");
        System.out.println(reservation.getPersonneId());
        System.out.println("--------------------------------");
        Personne personne = personneRepository.findById(reservation.getPersonneId()).orElse(null);
        Ressource ressource = resourceRestClient.findRessourceById(reservation.getRessourceId());

        if (personne != null && ressource != null) {
            reservation.setPersonne(personne);
            reservation.setRessource(ressource);
            reservation.setName("reservation"+new Random().nextInt(100));
            reservation.setDate(new Date());
            reservation.setContext("Informatique");
            reservation.setDuration(new Random().nextInt(2, 30));
            Reservation createdReservation = reservationRepository.save(reservation);

            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/addUser")
    public ResponseEntity<Personne> createPersonne(@RequestBody Personne p) {
        Personne personne = personneRepository.findById(p.getId()).orElse(null);
        if (personne == null ) {
            Personne personne1= Personne.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .email(p.getEmail())
                    .fonction("Unknow")
                    .build();
            Personne createdPersonne = personneRepository.save(personne1);

            return new ResponseEntity<>(createdPersonne, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
