import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WarehouseRoutingModule } from './warehouse-routing.module';
import { WarehouseStockComponent } from './warehouse-stock/warehouse-stock.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { OChartModule } from 'ontimize-web-ngx-charts';

@NgModule({
  declarations: [WarehouseStockComponent],
  imports: [
    CommonModule,
    WarehouseRoutingModule,
    OntimizeWebModule,
    OChartModule
  ]
})
export class WarehouseModule { }
