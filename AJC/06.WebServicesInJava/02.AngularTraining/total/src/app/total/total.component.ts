import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-total',
  templateUrl: './total.component.html',
  styleUrls: ['./total.component.css']
})
export class TotalComponent implements OnInit {
  theTotal = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  getTotal(value: number) {
    this.theTotal += value;
  }
}
