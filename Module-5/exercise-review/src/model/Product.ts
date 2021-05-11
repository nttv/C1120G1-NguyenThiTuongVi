export class Product {
    private _name: string;
    private _price: number;
    private _productionDate: string;
    private _amount: number;
    private _origin: string;

  constructor(name: string, price: number, productionDate: string, amount: number, origin: string) {
    this._name = name;
    this._price = price;
    this._productionDate = productionDate;
    this._amount = amount;
    this._origin = origin;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get productionDate(): string {
    return this._productionDate;
  }

  set productionDate(value: string) {
    this._productionDate = value;
  }

  get amount(): number {
    return this._amount;
  }

  set amount(value: number) {
    this._amount = value;
  }

  get origin(): string {
    return this._origin;
  }

  set origin(value: string) {
    this._origin = value;
  }
}
