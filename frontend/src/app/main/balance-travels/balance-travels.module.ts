import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BalanceTravelsRoutingModule } from './balance-travels-routing.module';
import { OTranslateService, OntimizeWebModule } from 'ontimize-web-ngx';
import { OChartModule } from 'ontimize-web-ngx-charts';
import { TravelsBalanceComponent } from './travels-balance/travels-balance.component';
import { D3LocaleService } from 'src/app/shared/d3locale.service';


@NgModule({
  declarations: [
    TravelsBalanceComponent,
  ],
  imports: [
    CommonModule,
    BalanceTravelsRoutingModule,
    OntimizeWebModule,
    OChartModule
  ],
  providers: [
    D3LocaleService
  ]
})
export class BalanceTravelsModule { }
