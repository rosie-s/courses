import {Component, Input, OnInit} from '@angular/core';
import {Supplier} from "./supplier.model";

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {

  @Input()
  supplierName: string;

  @Input()
  supplier: Supplier;

  constructor() { }

  ngOnInit(): void {
  }

}
