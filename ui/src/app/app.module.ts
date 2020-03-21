import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import {HttpClientModule} from "@angular/common/http";
import { ClientComponent } from './client/client.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ClientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
