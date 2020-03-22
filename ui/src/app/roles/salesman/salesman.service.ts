import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SalesmanService {

  private restUrl = environment.serverBaseUrl + '/sell/add';

  constructor(private http: HttpClient) { }

  public addNewSalesman(salesman) {
    this.http.put(this.restUrl, true, {
       params: {salesman: salesman}}).subscribe();
  }
}
