import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReservationService} from "../reservation-service.service";

@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrl: './reservation-details.component.css'
})
export class ReservationDetailsComponent implements OnInit {
  // @ts-ignore
  reservationId: number;
  reservation: any;

  constructor(private route: ActivatedRoute, private reservationService: ReservationService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.reservationId = params['id'];
      this.loadReservationDetails();
    });
  }

  loadReservationDetails() {
    // Appelez votre service pour obtenir les détails de la réservation par ID
    this.reservationService.getReservationById(this.reservationId).subscribe(
      (data: any) => {
        this.reservation = data;
      },
      error => {
        console.error('Erreur lors de la récupération des détails de la réservation', error);
        // Ajoutez ici le code de gestion des erreurs
      }
    );
  }
}
