import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { TravelsRoutingModule } from './travels-routing.module';
import { TravelsTableComponent } from './travels-table/travels-table.component';
import { TravelsDetailComponent } from './travels-detail/travels-detail.component';

import { OChartModule } from 'ontimize-web-ngx-charts';
import { TravelsErrorsRenderComponent } from './travels-table/travels-errors-render/travels-errors-render.component';



@NgModule({
  declarations: [
    TravelsTableComponent,
    TravelsDetailComponent,
    TravelsErrorsRenderComponent,
  ],
  imports: [
    CommonModule,
    TravelsRoutingModule,
    OntimizeWebModule,
    OChartModule
  ]
})
export class TravelsModule { }
