import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { TravelsRoutingModule } from './travels-routing.module';
import { TravelsTableComponent } from './travels-table/travels-table.component';

@NgModule({
  declarations: [
    TravelsTableComponent
  ],
  imports: [
    CommonModule,
    TravelsRoutingModule,
    OntimizeWebModule
  ]
})
export class TravelsModule { }
