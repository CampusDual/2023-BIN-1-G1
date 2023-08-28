import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompaniesRoutingModule } from './companies-routing.module';
import { CompaniesListComponent } from './companies-list/companies-list.component';
import { CompaniesDetailComponent } from './companies-detail/companies-detail.component';
import { CompaniesNewComponent } from './companies-new/companies-new.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CompaniesTrucksNewComponent } from './companies-trucks-new/companies-trucks-new.component';



@NgModule({
  declarations: [
    CompaniesListComponent, 
    CompaniesDetailComponent, 
    CompaniesNewComponent, 
    CompaniesTrucksNewComponent
  ],
  imports: [
    CommonModule,
    CompaniesRoutingModule,
    OntimizeWebModule
  ]
})
export class CompaniesModule { }
