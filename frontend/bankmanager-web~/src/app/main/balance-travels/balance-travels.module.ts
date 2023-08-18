import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BalanceTravelsRoutingModule } from './balance-travels-routing.module';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { OChartModule } from 'ontimize-web-ngx-charts';
import { TravelsBalanceComponent } from './travels-balance/travels-balance.component';


@NgModule({
  declarations: [
    TravelsBalanceComponent
  ],
  imports: [
    CommonModule,
    BalanceTravelsRoutingModule,
    OntimizeWebModule,
    OChartModule
  ]
})
export class BalanceTravelsModule { }
