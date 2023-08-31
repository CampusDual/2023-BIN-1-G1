import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompaniesBalanceRoutingModule } from './companies-balance-routing.module';
import { CompaniesBalanceComponent } from './companies-balance/companies-balance.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';


@NgModule({
  declarations: [CompaniesBalanceComponent],
  imports: [
    CommonModule,
    CompaniesBalanceRoutingModule,
    OntimizeWebModule
  ]
})
export class CompaniesBalanceModule { }
