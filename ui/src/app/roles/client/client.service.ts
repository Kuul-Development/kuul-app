import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Catalogue} from "./client.component";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private restUrl = environment.serverBaseUrl + '/buy/catalogue';

  constructor(private http: HttpClient) {
  }

  public getProductsPerSalesman() {
    return this.http.get<[Catalogue]>(this.restUrl);
  }
}
