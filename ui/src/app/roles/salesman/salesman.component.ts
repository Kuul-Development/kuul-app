import { Component, OnInit } from '@angular/core';
import {SalesmanService} from "./salesman.service";
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-salesman',
  templateUrl: './salesman.component.html',
  styleUrls: ['./salesman.component.css']
})
export class SalesmanComponent implements OnInit {
  salesmanAddForm: FormGroup;

  constructor(private salesmanService: SalesmanService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.salesmanAddForm = this.formBuilder.group({
      salesman: ''
    });
  }

  public onSalesmanAddClick() {
    this.salesmanService.addNewSalesman(this.salesmanAddForm.value.salesman);
  }
}
