import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsBalanceComponent } from './travels-balance/travels-balance.component';


const routes: Routes = [
  {
    path: "travels-balance",
    component: TravelsBalanceComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BalanceTravelsRoutingModule { }
