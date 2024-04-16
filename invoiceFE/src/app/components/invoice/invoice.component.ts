import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Delivery } from 'src/app/classes/Delivery.class';
import { DeliveryLine } from 'src/app/classes/DeliveryLine.class';
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
  matching = {
    isMatched: false,
    number: '',
  };
  delivery: Delivery | undefined;
  dyNumber = new FormControl('');

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
    this.invoice = new Invoice(1, [
      invoiceLine1,
      invoiceLine2,
      invoiceLine3,
      invoiceLine4,
    ]);
  }

  isInvoiceMatched(delivery_number: string): boolean {
    //this.isInvoiceMatched2nd();
    if (delivery_number === 'DLN001') {
      return true;
    }
    if (delivery_number === 'KYN005') {
      return true;
    }
    return false;
  }

  isInvoiceMatched2nd(dyNumber: string): boolean {
    const deliveryLine1 = new DeliveryLine('ProductY', '10', 50);
    const deliveryLine2 = new DeliveryLine('ProductK', '7', 28);
    this.delivery = new Delivery('1', dyNumber, [deliveryLine1, deliveryLine2]);

    let matching = {
      isMatched: false,
      number: '',
    };
    matching.number = this.delivery.delivery_number!;

    const itemsByDelivery = this.invoice?.lines?.filter(
      (line) => line.delivery_number === this.delivery!.delivery_number
    );
    console.log(itemsByDelivery);

    const titles = new Map<string, string>();
    let invoiceAmountByDelivery = 0.0;
    itemsByDelivery?.forEach((item) => {
      titles.set(item.title!, item.unit!);
      invoiceAmountByDelivery += item.amount!;
    });
    console.log(titles);

    let isTitleMatched;
    let deliveryAmount = 0.0;
    this.delivery.delivery_lines?.forEach((line) => {
      deliveryAmount += line.amount!;
      isTitleMatched = titles.get(line.title!);
      if (isTitleMatched === undefined) {
        matching.isMatched = false;
      } else {
        matching.isMatched =
          titles.get(line.title!) === line.unit! ? true : false;
      }
    });

    console.log(deliveryAmount,invoiceAmountByDelivery)
    if(deliveryAmount !== invoiceAmountByDelivery){
      matching.isMatched = false;
    }

    this.matching = matching;
    console.log(matching);

    //remainng check for the amount

    return matching.isMatched;
  }
}
