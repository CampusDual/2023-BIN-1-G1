import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompaniesRoutingModule } from './companies-routing.module';
import { CompaniesListComponent } from './companies-list/companies-list.component';
import { CompaniesDetailComponent } from './companies-detail/companies-detail.component';
import { CompaniesNewComponent } from './companies-new/companies-new.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { CompaniesTrucksNewComponent } from './companies-trucks-new/companies-trucks-new.component';
import { SharedModule } from '../../shared/shared.module';

@NgModule({
  declarations: [
    CompaniesListComponent, 
    CompaniesDetailComponent, 
    CompaniesNewComponent, 
    CompaniesTrucksNewComponent,
  ],
  imports: [
    SharedModule,
    CommonModule,
    CompaniesRoutingModule,
    OntimizeWebModule
  ]
})
export class CompaniesModule { }
