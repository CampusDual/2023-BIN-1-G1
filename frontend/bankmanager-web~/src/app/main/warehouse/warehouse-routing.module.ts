import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WarehouseStockComponent } from './warehouse-stock/warehouse-stock.component';


const routes: Routes = [{
  path: '',
  component: WarehouseStockComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WarehouseRoutingModule { }
