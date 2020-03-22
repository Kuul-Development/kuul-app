import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./client.component";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private restUrl = environment.serverBaseUrl + '/client/products';

  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<[Product]>(this.restUrl);
  }
}
