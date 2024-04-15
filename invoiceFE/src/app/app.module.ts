import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { DeliveryComponent } from './components/delivery/delivery.component';
import { DeliveryLineItemComponent } from './components/delivery-line-item/delivery-line-item.component';
import { InvoiceLineItemComponent } from './components/invoice-line-item/invoice-line-item.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    InvoiceComponent,
    DeliveryComponent,
    DeliveryLineItemComponent,
    InvoiceLineItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
