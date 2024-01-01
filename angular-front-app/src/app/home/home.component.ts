import {Component, OnInit} from '@angular/core';
import {KeycloakProfile} from "keycloak-js";
import {HttpClient} from "@angular/common/http";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  public profile?: KeycloakProfile;

  constructor(private http: HttpClient, public keycloakService: KeycloakService) {
  }

  ngOnInit(): void {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
        this.sendDataToBackend(profile);
      });
    }
  }


  private sendDataToBackend(profile: any,) {
    const backendUrl = 'http://localhost:9999/RESERVATION-SERVICE/addUser';

    const data = {
      id:profile.id,
      name: profile.username,
      email: profile.email,

    };

    this.http.post(backendUrl, data).subscribe(
      response => {
        console.log('Données envoyées avec succès au backend', response);
      },
      error => {
        console.error('Erreur lors de l\'envoi des données au backend', error);
      }
    );
  }

}
