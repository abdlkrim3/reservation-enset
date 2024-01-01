import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourceComponent} from "./resource/resource.component";
import {ReservationComponent} from "./reservation/reservation.component";
import {AuthGuard} from "./guards/auth.guard";
import {UserComponent} from "./user/user.component";
import {HomeComponent} from "./home/home.component";
import {ReservationDetailsComponent} from "./reservation-details/reservation-details.component";

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path:"home",component:HomeComponent,canActivate:[AuthGuard],data:{roles:['USER']}},
  {path:"ressources", component:ResourceComponent,canActivate:[AuthGuard],data:{roles:['USER']}},
  {path:"reservations", component:ReservationComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path:"users",component:UserComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path: 'reservation/:id',component:ReservationDetailsComponent},
  {path: 'reservationById',component:ReservationDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
