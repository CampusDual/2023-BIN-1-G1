import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService, PermissionsGuardService } from 'ontimize-web-ngx';

import { MainComponent } from './main.component';

export const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    canActivate: [AuthGuardService],
    canActivateChild: [PermissionsGuardService],
    children: [
      { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule) },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { 
        path: 'travels', loadChildren: () => import('./travels/travels.module').then(m => m.TravelsModule),
        data: {
          oPermission: {
            restrictedPermissionsRedirect: '403'
          }
        }
    
      },
      { path: 'balance-travels', loadChildren: () => import('./balance-travels/balance-travels.module').then(m => m.BalanceTravelsModule)},
      { path: 'warehouse', loadChildren: () => import('./warehouse/warehouse.module').then(m => m.WarehouseModule)},
      { path: 'trucks', loadChildren: () => import('./trucks-movements/trucks-movements.module').then(m => m.TrucksMovementsModule)},
      { path: 'companies', loadChildren: () => import('./companies/companies.module').then(m => m.CompaniesModule)},
      { path: 'companies-balance', loadChildren: () => import('./companies-balance/companies-balance.module').then(m => m.CompaniesBalanceModule)},
      { path: 'travels-by-user', loadChildren: () => import('./travels-by-user/travels-by-user.module').then(m => m.TravelsByUserModule)}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
