import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TravelsByUserRoutingModule } from './travels-by-user-routing.module';
import { TravelsByUserListComponent } from './travels-by-user-list/travels-by-user-list.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';


@NgModule({
  declarations: [TravelsByUserListComponent],
  imports: [
    CommonModule,
    TravelsByUserRoutingModule,
    OntimizeWebModule
  ]
})
export class TravelsByUserModule { }
