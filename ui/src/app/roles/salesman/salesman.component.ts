import { Component, OnInit } from '@angular/core';
import {SalesmanService} from "./salesman.service";
import { FormBuilder, FormGroup } from '@angular/forms';
import {Observable} from "rxjs";

@Component({
  selector: 'app-salesman',
  templateUrl: './salesman.component.html',
  styleUrls: ['./salesman.component.css']
})
export class SalesmanComponent implements OnInit {
  salesmanAddForm: FormGroup;
  salesmanAddProductForm: FormGroup;

  salesmanList: Observable<Salesman[]>;
  productsOfSalesman: Observable<Product[]>;

  constructor(private salesmanService: SalesmanService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.salesmanAddForm = this.formBuilder.group({
      salesman: ''
    });
    this.salesmanList = this.salesmanService.getAllSalesmen();
    this.salesmanAddProductForm = this.formBuilder.group({
      id: '',
      product: '',
      desc: '',
      amount: '',
      price: ''
    });
  }

  public async onAddSalesman() {
    await this.salesmanService.addNewSalesman(this.salesmanAddForm.value.salesman);
    this.salesmanList = this.salesmanService.getAllSalesmen();
  }

  public async onAddProductToSalesman() {
    const input = this.salesmanAddProductForm.value;
    await this.salesmanService.addNewProduct(input.id, input.product, input.desc, input.amount, input.price);
    this.productsOfSalesman = this.salesmanService.getAllProducts(input.id);
  }
}

export class Salesman {
  id: number;
  name: string;
}

export class Product {
  product: string;
  amount: number;
  description: string;
  price: number;
}
