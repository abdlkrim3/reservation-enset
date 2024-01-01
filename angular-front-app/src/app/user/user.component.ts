import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{

  users:any;
  constructor(private http:HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/RESERVATION-SERVICE/users")
      .subscribe({
        next: data => {
          this.users=data;
        },
        error:err => {
          console.log(err)
        }
      });
  }

}

