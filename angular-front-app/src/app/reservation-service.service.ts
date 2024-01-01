import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private backendUrl = 'http://localhost:9999/RESERVATION-SERVICE/reservations';

  constructor(private http: HttpClient) {}

  getReservationById(id: number): Observable<any> {
    return this.http.get(`${this.backendUrl}/${id}`);
  }
}
