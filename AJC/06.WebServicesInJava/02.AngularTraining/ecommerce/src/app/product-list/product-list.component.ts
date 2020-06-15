import {Component, OnInit, Output} from '@angular/core';
import {Product} from "../product/product.model";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  bike = new Product(1, "Bike", "Ducatti");
  car = new Product(5, "Car", "Lamborghini");
  television = new Product(2, "Television", "A big tv")
  productClicked: string;

  clicked: boolean

  constructor() {
  }

  ngOnInit(): void {
  }

  getSize(value: number) {
    console.log(value);
  }

  setClicked(product: string) {
    this.productClicked = product;
    this.clicked = true
  }

  allProducts() {
    return [this.bike, this.car, this.television];

  }
}
