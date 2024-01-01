import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {KeycloakProfile} from "keycloak-js";
import {KeycloakService} from "keycloak-angular";
import {Router} from "@angular/router";

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrl: './resource.component.css'
})
export class ResourceComponent implements OnInit {

  ressources: any;
  public profile?: KeycloakProfile;

  constructor(private http: HttpClient, public keycloakService: KeycloakService,private router: Router) {
  }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/RESSOURCE-SERVICE/ressources")
      .subscribe({
        next: data => {
          this.ressources = data;
        },
        error: err => {
          console.log(err)
        }
      });
  }

  reserveResource(resourceId: any) {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
        this.sendDataToBackend(profile, resourceId);
      });
    }
  }

  private sendDataToBackend(profile: any, resourceId: any) {
    const backendUrl = 'http://localhost:9999/RESERVATION-SERVICE/reserve';

    const data = {
      personneId:profile.id,
      ressourceId: resourceId,
    };

    this.http.post(backendUrl, data).subscribe(
      (response: any) => {
        console.log('Données envoyées avec succès au backend', response);

        // Rediriger vers la nouvelle page avec l'ID de la réservation
        this.router.navigate(['/reservation', response.id]);
      },
      error => {
        console.error('Erreur lors de l\'envoi des données au backend', error);
        // Ajoutez ici le code de gestion des erreurs
      }
    );
  }

}
