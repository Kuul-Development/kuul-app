import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ClientService} from "./client.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  catalogue: Observable<Catalogue[]>;

  constructor(private productService: ClientService) { }

  ngOnInit() {
    this.catalogue = this.productService.getProductsPerSalesman();
  }

  ngOnClick() {

  }
}

export class Catalogue {
  salesman: string;
  products: Product[]
}
export class Product {
  product: string;
  amount: number;
  description: string;
  price: number;
}
