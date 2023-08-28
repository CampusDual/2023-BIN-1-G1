import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsTableComponent } from './travels-table/travels-table.component';
import { TravelsDetailComponent } from './travels-detail/travels-detail.component';

const routes: Routes = [
  {
    path: 'travels-list',
    component: TravelsTableComponent
  },
  {
    path: "travels-list/:id_travel",
    component: TravelsDetailComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TravelsRoutingModule { }
