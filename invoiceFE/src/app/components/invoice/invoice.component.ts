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
    const invoiceLine1 = new InvoiceLine('DLN001', 'ProductX', '10m3', 5, 50);
    const invoiceLine2 = new InvoiceLine('DLN001', 'ProductY', '7kg', 4, 28);
    const invoiceLine3 = new InvoiceLine('XFN001', 'ProductZ', '8t', 2, 16);
    const invoiceLine4 = new InvoiceLine('KYN005', 'ProductK', '1T', 2, 2);
    this.invoice = new Invoice(1, [
      invoiceLine1,
      invoiceLine2,
      invoiceLine3,
      invoiceLine4,
    ]);
  }

  /**
   * @ngdoc function
   * @name compareInvoiceByDeliveryNumber
   * @methodOf
   * @description
   *
   * ----> !!!!IMPORTANT!!!! <----
   * The algorithm is here just for testing purposes.
   * THe logic should be located in the backend side
   * ---------------------
   *
   * This method is used to check if an invoice matches with delivery notes
   * So far the algorithm create from scratch dummy data and variables;
   * In general it is supposed to get them from an external services like Rest APIs.
   *
   * The algorithm for now only works a dummy unit like normal string and basic criteria of equality
   * like 5 === 5.
   * To face all scenarios I should apply some edit_distance principles.
   */
  compareInvoiceByDeliveryNumber(dyNumber: string): boolean {
    const deliveryLine1 = new DeliveryLine('ProductX', '10m3', 50);
    const deliveryLine2 = new DeliveryLine('ProductY', '7kg', 29);
    this.delivery = new Delivery('1', dyNumber, [deliveryLine1, deliveryLine2]);

    let matching = {
      isMatched: false,
      number: '',
    };
    matching.number = this.delivery.delivery_number!;

    const itemsByDelivery = this.invoice?.lines?.filter(
      (line) => line.delivery_number === this.delivery!.delivery_number
    );

    const titles = new Map<string, string>();
    let invoiceAmountByDelivery = 0.0;
    itemsByDelivery?.forEach((item) => {
      titles.set(item.title!, item.unit!);
      invoiceAmountByDelivery += item.amount!;
    });

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

    if (deliveryAmount !== invoiceAmountByDelivery) {
      matching.isMatched = false;
    }

    this.matching = matching;

    return matching.isMatched;
  }
}
