import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsByUserListComponent } from './travels-by-user-list/travels-by-user-list.component';


const routes: Routes = [
  {
    path: '',
    component: TravelsByUserListComponent,
    data: {
      oPermission: {
        permissionId: 'travels-by-user-table-route',
        restrictedPermissionsRedirect: '403'
      }
    }

  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TravelsByUserRoutingModule { }
