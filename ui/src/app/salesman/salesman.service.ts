import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SalesmanService {

  private baseUrl = 'http://localhost:8080/kuul-server-1.0-SNAPSHOT/rest';
  private restUrl = this.baseUrl + '/sell/add';

  constructor(private http: HttpClient) { }

  public addNewSalesman(salesman) {
    console.log("hi");
    this.http.put(this.restUrl, true, {
       params: {salesman: salesman}}).subscribe();
  }
}
