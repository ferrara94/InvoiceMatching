export class DeliveryLine {
  title?: string;
  unit?: string;
  amount?: number;

  constructor(title?: string, unit?: string, amount?: number) {
    this.title = title;
    this.unit = unit;
    this.amount = amount;
  }
}
