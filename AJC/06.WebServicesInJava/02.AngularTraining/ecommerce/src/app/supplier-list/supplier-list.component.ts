import {Component, OnInit} from '@angular/core';
import {Supplier} from "../supplier/supplier.model";

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css']
})
export class SupplierListComponent implements OnInit {

  supplier1 = new Supplier("Company1", "123456789014")
  supplier2 = new Supplier("Company2", "AB1231458674")
  supplier3 = new Supplier("Company3", "123456789")

  constructor() {
  }

  ngOnInit(): void {
  }

  allSuppliers() {
    return [this.supplier1, this.supplier2, this.supplier3]
  }
}
