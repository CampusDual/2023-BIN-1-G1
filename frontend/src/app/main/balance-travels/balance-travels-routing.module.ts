import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsBalanceComponent } from './travels-balance/travels-balance.component';


const routes: Routes = [
  {
    path: "",
    component: TravelsBalanceComponent,
    data: {
      oPermission: {
        permissionId: 'balance-table-route',
        restrictedPermissionsRedirect: '403'
      }
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BalanceTravelsRoutingModule { }
