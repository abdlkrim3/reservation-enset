package ma.sdia.ressourceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.sdia.ressourceservice.enums.ResourceType;
@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ResourceType type;


}
