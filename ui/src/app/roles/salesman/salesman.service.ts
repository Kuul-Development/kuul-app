import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Product, Salesman} from "./salesman.component";

@Injectable({
  providedIn: 'root'
})
export class SalesmanService {

  constructor(private http: HttpClient) { }

  public addNewSalesman(salesman) {
    const restUrl = environment.serverBaseUrl + '/sell/salesman';
    this.http.put(restUrl, true, {
       params: {salesman: salesman}}).subscribe();
  }

  public getAllSalesmen(): Observable<Salesman[]> {
    const restUrl = environment.serverBaseUrl + '/sell/allsalesmen';
    return this.http.get<[Salesman]>(restUrl);
  }

  public addNewProduct(id, product, desc, amount, price) {
    const restUrl = environment.serverBaseUrl + '/sell/product';
    return this.http.put(restUrl,true, {
      params: {id:id, product:product, desc:desc, amount:amount, price:price}
    }).subscribe();
  }

  public getAllProducts(id) {
    const restUrl = environment.serverBaseUrl + '/sell/store';
    return this.http.get<[Product]>(restUrl, {params: {id:id}});
  }
}
