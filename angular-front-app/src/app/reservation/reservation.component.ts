import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.css'
})
export class ReservationComponent implements OnInit{
  reservations:any;
  constructor(private http:HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/RESERVATION-SERVICE/reservations")
      .subscribe({
        next: data => {
          this.reservations=data;
        },
        error:err => {
          console.log(err)
        }
      });
  }

}
