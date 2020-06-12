export class PersonModel {
  private _name: string
  private _lastName: string
  private _age: number

  constructor(name: string, lastName: string, age: number) {
    this._name = name;
    this._lastName = lastName;
    this._age = age;
  }


  get getFullDetails(): string {
    return "Name:  " + this._name + " " + this._lastName + ", Age: " + this._age;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get age(): number {
    return this._age;
  }

  set age(value: number) {
    this._age = value;
  }
}
