import { Component, OnInit } from '@angular/core';
import {ProductService} from "./product.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productList: Observable<Product[]>;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productList = this.productService.getAllProducts();
  }

}

export class Product {
  productId: string;
  amount: number;
  description: string;
}
