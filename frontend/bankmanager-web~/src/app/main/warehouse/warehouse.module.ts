import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WarehouseRoutingModule } from './warehouse-routing.module';
import { WarehouseStockComponent } from './warehouse-stock/warehouse-stock.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';


@NgModule({
  declarations: [WarehouseStockComponent],
  imports: [
    CommonModule,
    WarehouseRoutingModule,
    OntimizeWebModule
  ]
})
export class WarehouseModule { }
