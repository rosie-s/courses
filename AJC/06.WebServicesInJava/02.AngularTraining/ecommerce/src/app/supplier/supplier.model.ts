export class Supplier {
  private _companyName: string;
  private _accNumber: string;


  constructor(companyName: string, accNumber: string) {
    this._companyName = companyName;
    this._accNumber = accNumber;
  }

  get companyName(): string {
    return this._companyName;
  }

  set companyName(value: string) {
    this._companyName = value;
  }

  get accNumber(): string {
    return this._accNumber;
  }

  set accNumber(value: string) {
    this._accNumber = value;
  }

  get toString() : string
  {
    return "{" + this._companyName + ", bank account: " + this._accNumber + "}"
  }

}
