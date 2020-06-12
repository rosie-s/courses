import {Component, OnInit} from '@angular/core';
import {Product} from "../product/product.model";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  bike = new Product(1, "Bike", "Ducatti");
  car = new Product(5, "Car", "Lamborghini");

  constructor() {
  }

  ngOnInit(): void {
  }

  getSize(value: number) {
    console.log(value);
  }

}
