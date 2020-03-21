import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "./product.component";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/kuul-server-1.0-SNAPSHOT/rest';
  private restUrl = this.baseUrl + '/client/products';


  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<[Product]>(this.restUrl);
  }
}
