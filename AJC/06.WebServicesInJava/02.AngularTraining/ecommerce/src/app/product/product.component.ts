import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {Product} from "./product.model";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input()
  productType: string

  @Input()
  productName: string

  @Output()
  outputElement = new EventEmitter<number>()

  constructor() {
  }


  ngOnInit(): void {
  }

  @HostListener('click')
  sendMessage() {
    this.outputElement.emit(this.productName.length);
  }

}
