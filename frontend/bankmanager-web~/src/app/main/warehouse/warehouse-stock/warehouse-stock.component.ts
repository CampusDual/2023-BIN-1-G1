import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-warehouse-stock',
  templateUrl: './warehouse-stock.component.html',
  styleUrls: ['./warehouse-stock.component.css']
})
export class WarehouseStockComponent implements OnInit {
  table_data = [{
    "stock": 0,
    "max_stock": 0,
    "percentage": 0
  }];
  constructor() { }

  ngOnInit() {
  }

  ondataloaded(event){
    console.log(event);
    this.table_data[0].stock = event[0].stock;
    this.table_data[0].max_stock = event[1].stock;
    this.table_data[0].percentage = (event[0].stock/event[1].stock)*100;

  }


}
