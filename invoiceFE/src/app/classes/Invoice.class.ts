import { InvoiceLine } from './InvoiceLine.class';

export class Invoice {
  id?: number;
  lines?: InvoiceLine[];

  constructor(id?: number, lines?: InvoiceLine[]) {
    this.id = id;
    this.lines = lines;
  }
}
