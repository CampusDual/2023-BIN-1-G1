import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrucksMovementsRoutingModule } from './trucks-movements-routing.module';
import { TrucksViewComponent } from './trucks-view/trucks-view.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { OChartModule } from 'ontimize-web-ngx-charts';


@NgModule({
  declarations: [
    TrucksViewComponent
  ],
  imports: [
    CommonModule,
    OntimizeWebModule,
    TrucksMovementsRoutingModule,
    OChartModule
  ]
})
export class TrucksMovementsModule { }
