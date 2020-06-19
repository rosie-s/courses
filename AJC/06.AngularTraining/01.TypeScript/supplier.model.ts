export class Supplier {
    private _id: number;
    private _companyName: string;
    private _bankAccountNumber: number;

    constructor(id: number, companyName: string, bankAccountNumber: number) {
        this._id = id;
        this._companyName = companyName;
        this._bankAccountNumber = bankAccountNumber;
    }

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get companyName(): string {
        return this._companyName;
    }

    set companyName(value: string) {
        this._companyName = value;
    }

    get bankAccountNumber(): number {
        return this._bankAccountNumber;
    }

    set bankAccountNumber(value: number) {
        this._bankAccountNumber = value;
    }
}