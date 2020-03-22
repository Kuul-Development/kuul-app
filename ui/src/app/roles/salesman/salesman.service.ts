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
    let restUrl = environment.serverBaseUrl + '/sell/add';
    this.http.put(restUrl, true, {
       params: {salesman: salesman}}).subscribe();
  }

  public getAllSalesmen(): Observable<Salesman[]> {
    let restUrl = environment.serverBaseUrl + '/sell/getallsalesmen';
    return this.http.get<[Salesman]>(restUrl);
  }

  public addNewProduct(id, product, desc, amount, price) {
    let restUrl = environment.serverBaseUrl + '/sell/addproduct';
    return this.http.put(restUrl,true, {
      params: {id:id, product:product, desc:desc, amount:amount, price:price}
    }).subscribe();
  }

  public getAllProducts(id) {
    let restUrl = environment.serverBaseUrl + '/sell/getstore';
    return this.http.get<[Product]>(restUrl, {params: {id:id}});
  }
}
