import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {Product} from "./product.model";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input()
  productType: string;

  @Input()
  productName: string;

  @Input()
  product: Product;

  @Output()
  outputElement = new EventEmitter<number>();

  @Output()
  outputProduct: EventEmitter<string> = new EventEmitter();

  constructor() {
  }


  ngOnInit(): void {
  }

  @HostListener('click')
  sendMessage() {
    this.outputElement.emit(this.productName.length);
    this.outputProduct.emit(this.productType.toString());
  }
}
