import {Component} from '@angular/core';
import {PersonModel} from "./model/person.model";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularTraining';
  theColour = 'red';
  theValue ='';
  thePerson = new PersonModel('Rosie' ,'S', 27)
  thePerson2 = new PersonModel('Rose' ,'Mary', 28)

  toggleColour() {
    if (this.theColour == 'red') {
      this.theColour = 'blue';
    } else {
      this.theColour = 'red';
    }
  }
  displayText(e) {
    alert("You rebel!! I said " + e.target.innerHTML)
  }
  toggleDetails(){
    if (this.thePerson == this.thePerson){
      this.thePerson = this.thePerson2;
    }  else{
      this.thePerson = this.thePerson;
    }
  }

  popup() {
    this.theColour = this.theValue;
  }


}
