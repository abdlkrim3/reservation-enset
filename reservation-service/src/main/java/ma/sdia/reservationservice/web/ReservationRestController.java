package ma.sdia.reservationservice.web;

import ma.sdia.reservationservice.entities.Reservation;
import ma.sdia.reservationservice.repositories.ReservationRepository;
import ma.sdia.ressourceservice.entities.Ressource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationRestController {
    private ReservationRepository reservationRepository;
    private ResourceRestClient resourceRestClient;
    public ReservationRestController(ReservationRepository reservationRepository, ResourceRestClient resourceRestClient) {
        this.reservationRepository = reservationRepository;
        this.resourceRestClient = resourceRestClient;
    }

    @GetMapping("/reservation")
    public List<Reservation> reservationList(){
        List<Reservation> reservationList = reservationRepository.findAll();
        reservationList.forEach(rserv->{
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

}
