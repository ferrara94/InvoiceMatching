import { DeliveryLine } from './DeliveryLine.class';

export class Delivery {
  id?: string;
  delivery_number?: string;

  delivery_lines?: DeliveryLine[];

  constructor(
    id?: string,
    delivery_number?: string,
    delivery_lines?: DeliveryLine[]
  ) {
    this.id = id;
    this.delivery_number = delivery_number;
    this.delivery_lines = delivery_lines;
  }
}
