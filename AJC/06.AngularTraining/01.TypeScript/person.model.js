"use strict";
exports.__esModule = true;
exports.Product = exports.Supplier = exports.Person = void 0;
var Person = /** @class */ (function () {
    function Person(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    return Person;
}());
exports.Person = Person;
var Supplier = /** @class */ (function () {
    function Supplier(id, companyName, bankAccountNumber) {
        this.id = id;
        this.companyName = companyName;
        this.bankAccountNumber = bankAccountNumber;
    }
    return Supplier;
}());
exports.Supplier = Supplier;
var Product = /** @class */ (function () {
    function Product() {
    }
    return Product;
}());
exports.Product = Product;
