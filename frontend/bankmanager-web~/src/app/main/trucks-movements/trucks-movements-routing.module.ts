import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrucksViewComponent } from './trucks-view/trucks-view.component';


const routes: Routes = [
  {
    path: "",
    component: TrucksViewComponent,
    data: {
      oPermission: {
        permissionId: 'trucks-movements-table-route',
        restrictedPermissionsRedirect: '403'
      }
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TrucksMovementsRoutingModule { }
