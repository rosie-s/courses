export class Product {
    private _id: number;
    private _name: string;
    private _description: string;
    private _price: number;
    private _supplier: string;
    private _category: string;
    private _promo: string;

    constructor(id: number, name: string, description: string, price: number, supplier?: string, category?: string, promo?: string) {
        this._id = id;
        this._name = name;
        this._description = description;
        this._price = price;
        this._supplier = supplier;
        this._category = category;
        this._promo = promo;
    }


    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get description(): string {
        return this._description;
    }

    set description(value: string) {
        this._description = value;
    }

    get price(): number {
        return this._price;
    }

    set price(value: number) {
        this._price = value;
    }

    get supplier(): string {
        return this._supplier;
    }

    set supplier(value: string) {
        this._supplier = value;
    }

    get category(): string {
        return this._category;
    }

    set category(value: string) {
        this._category = value;
    }

    get promo(): string {
        return this._promo;
    }

    set promo(value: string) {
        this._promo = value;
    }
}