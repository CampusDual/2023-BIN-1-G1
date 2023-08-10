import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { TravelsRoutingModule } from './travels-routing.module';
import { TravelsTableComponent } from './travels-table/travels-table.component';
import { TravelsDetailComponent } from './travels-detail/travels-detail.component';

@NgModule({
  declarations: [
    TravelsTableComponent,
    TravelsDetailComponent
  ],
  imports: [
    CommonModule,
    TravelsRoutingModule,
    OntimizeWebModule
  ]
})
export class TravelsModule { }
