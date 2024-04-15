import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/classes/Invoice.class';
import { InvoiceLine } from 'src/app/classes/InvoiceLine.class';
import { InvoiceService } from 'src/app/services/invoice/invoice.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss'],
})
export class InvoiceComponent implements OnInit {
  invoice: Invoice | undefined;
  isMatched: boolean = true;

  constructor(private invoiceService: InvoiceService) {
    this.LoadInvoice();
  }

  ngOnInit(): void {}

  LoadInvoice() {
    /**
      this.invoiceService.getInvoice(id).subscribe(res=>{
        this.invoice = res;
      });
     */
    const invoiceLine1 = new InvoiceLine('DLN001', 'ProductX', '10', 5, 50);
    const invoiceLine2 = new InvoiceLine('DLN001', 'ProductY', '7', 4, 28);
    const invoiceLine3 = new InvoiceLine('XFN001', 'ProductZ', '8', 2, 16);
    const invoiceLine4 = new InvoiceLine('KYN005', 'ProductK', '1', 2, 2);
    this.invoice = new Invoice(1, [invoiceLine1, invoiceLine2, invoiceLine3, invoiceLine4]);
  }

  isInvoiceMatched(delivery_number: string): boolean {
    if(delivery_number === "DLN001"){
      return true;
    }
    if(delivery_number === "KYN005"){
      return true;
    }
    return false;

  }

}
