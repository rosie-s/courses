import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-number',
  templateUrl: './number.component.html',
  styleUrls: ['./number.component.css']
})
export class NumberComponent implements OnInit {

  constructor() { }
  theInit = 0

  @Output()
  o = new EventEmitter<number>()
  ngOnInit(): void {
  }

  add() {
    this.theInit =  this.theInit + 1;
    this.o.emit(1)
  }

  subtract() {
    this.theInit =  this.theInit - 1;
    this.o.emit(-1)

  }

  reset() {
    this.theInit = 0;
  }
}
