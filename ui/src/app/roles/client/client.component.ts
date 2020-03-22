import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ClientService} from "./client.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  catalogue: Observable<Product[]>;

  constructor(private productService: ClientService) { }

  ngOnInit() {
    this.catalogue = this.productService.getAllProducts();
  }

  ngOnClick() {

  }
}

export class Product {
  product: string;
  amount: number;
  desc: string;
  price: number;
}
