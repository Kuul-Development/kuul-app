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

const appRoutes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'roles', component: RolesComponent, pathMatch: 'full' }
];


@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    SalesmanComponent,
    RolesComponent
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
