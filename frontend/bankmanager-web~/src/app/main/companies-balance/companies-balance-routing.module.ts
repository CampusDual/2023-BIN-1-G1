import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompaniesBalanceComponent } from './companies-balance/companies-balance.component';


const routes: Routes = [
  {
    path: "",
    component: CompaniesBalanceComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompaniesBalanceRoutingModule { }
