package ma.sdia.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.sdia.reservationservice.model.Ressource;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String context;

    private Date date;
    private int duration;
    @Transient
    private Ressource ressource;
    private Long ressourceId;
    @Transient
    private Personne personne;
    private String personneId;



}
