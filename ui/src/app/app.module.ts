import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { ClientComponent } from './roles/client/client.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule, Routes } from '@angular/router';
import { SalesmanComponent } from './roles/salesman/salesman.component';
import {ReactiveFormsModule} from "@angular/forms";
import { RolesComponent } from './roles/roles.component';
import {AccountComponent} from "./account/account.component";
import { DeliveryComponent } from './roles/delivery/delivery.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'client', component: ClientComponent, pathMatch: 'full' },
  { path: 'account', component: AccountComponent, pathMatch: 'full' },
  { path: 'delivery', component: DeliveryComponent, pathMatch: 'full' },
  { path: 'salesman', component: SalesmanComponent, pathMatch: 'full' }
];


@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    SalesmanComponent,
    RolesComponent,
    AccountComponent,
    DeliveryComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    NgbModule,
    FontAwesomeModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
