export class InvoiceLine {
  delivery_number?: string;
  title?: string;
  unit?: string;
  amount?: number;
  price?: number;

  constructor(
    delivery_number?: string,
    title?: string,
    unit?: string,
    price?: number,
    amount?: number
  ) {
    this.delivery_number = delivery_number;
    this.title = title;
    this.unit = unit;
    this.amount = amount;
    this.price = price;
  }
}
