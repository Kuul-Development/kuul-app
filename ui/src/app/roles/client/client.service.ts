import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./client.component";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private restUrl = environment.serverBaseUrl + '/sell/getstore';

  constructor(private http: HttpClient) { }

  public getAllProducts() {
    return this.http.get<[Product]>(this.restUrl, {params: {id:'1'}});
  }
}
