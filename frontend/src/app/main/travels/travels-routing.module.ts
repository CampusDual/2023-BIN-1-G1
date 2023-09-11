import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsTableComponent } from './travels-table/travels-table.component';
import { TravelsDetailComponent } from './travels-detail/travels-detail.component';

const routes: Routes = [
  {
    path: '',
    component: TravelsTableComponent,
    data: {
      oPermission: {
        permissionId: 'travels-table-route',
        restrictedPermissionsRedirect: '403'
      }
    }
  },
  {
    path: ":id_travel",
    component: TravelsDetailComponent

  }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TravelsRoutingModule { }
