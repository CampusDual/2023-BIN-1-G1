import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TravelsTableComponent } from './travels-table/travels-table.component';


const routes: Routes = [{
  path: '',
  component: TravelsTableComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TravelsRoutingModule { }
