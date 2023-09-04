import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompaniesListComponent } from './companies-list/companies-list.component';
import { CompaniesDetailComponent } from './companies-detail/companies-detail.component';
import { CompaniesNewComponent } from './companies-new/companies-new.component';
import { CompaniesTrucksNewComponent } from './companies-trucks-new/companies-trucks-new.component';

const routes: Routes = [
  {
    path: "", 
    component: CompaniesListComponent,
    /*data: { oAppHeaderTitle: 'Companies'}*/
  },
  {
    path: "new",
    component: CompaniesNewComponent,
    /*data: { oAppHeaderTitle: 'Companies'}*/
  },
  {
    path: ":id_company",
    component: CompaniesDetailComponent,
    /*data: { oAppHeaderTitle: 'Companies'}*/
  },
  {
    path: ":id_company/new",
    component: CompaniesTrucksNewComponent,
    /*data: { oAppHeaderTitle: 'Companies'}*/
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompaniesRoutingModule { }
