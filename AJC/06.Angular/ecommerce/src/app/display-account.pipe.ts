import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'displayAccount'
})
export class DisplayAccountPipe implements PipeTransform {

  transform(value: string, length: number): string {

    if (value.length == length) {
      return value.substr(0, 4).padEnd(12, '*');
    } else {
      return "Incorrect account number";
    }
  }

}
