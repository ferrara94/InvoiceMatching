import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvoiceComponent } from './components/invoice/invoice.component';
import { DeliveryComponent } from './components/delivery/delivery.component';

const routes: Routes = [
  {component:InvoiceComponent,path:""},
  {component:DeliveryComponent,path:"delivery"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
