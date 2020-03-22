import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./client.component";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl = 'http://localhost:8080/kuul-server-1.0-SNAPSHOT/rest';
  private restUrl = this.baseUrl + '/client/products';


  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<[Product]>(this.restUrl);
  }
}
