import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourceComponent } from './resource/resource.component';
import { ReservationComponent } from './reservation/reservation.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'sdia-realm',
        clientId: 'sdia-reservation-client'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
@NgModule({
  declarations: [
    AppComponent,
    ResourceComponent,
    ReservationComponent,
    UserComponent,
    HomeComponent,
    ReservationDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [
    {provide:APP_INITIALIZER,deps:[KeycloakService],useFactory:initializeKeycloak,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
