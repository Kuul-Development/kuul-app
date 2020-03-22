import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ProductService} from "../product/product.service";
import {Product} from "../product/product.component";

@Component({
  selector: 'app-customer',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  productList: Observable<Product[]>;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productList = this.productService.getAllProducts();
  }

  ngOnClick() {

  }

}
