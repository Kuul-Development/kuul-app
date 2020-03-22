import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ClientService} from "./client.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  productList: Observable<Product[]>;

  constructor(private productService: ClientService) { }

  ngOnInit() {
    this.productList = this.productService.getAllProducts();
  }

  ngOnClick() {

  }
}

export class Product {
  productId: string;
  amount: number;
  description: string;
  salesman: string;
  price: number;
}
