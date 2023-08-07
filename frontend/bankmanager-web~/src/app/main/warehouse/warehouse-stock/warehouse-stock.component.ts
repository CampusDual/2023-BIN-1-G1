import { Component, OnInit, ViewChild } from '@angular/core';
import {
  OChartComponent, DataAdapterUtils, GaugeSlimChartConfiguration, GaugeSpaceChartConfiguration,
  RadialPercentChartConfiguration, GaugeDashboardChartConfiguration
} from 'ontimize-web-ngx-charts';

@Component({
  selector: 'app-warehouse-stock',
  templateUrl: './warehouse-stock.component.html',
  styleUrls: ['./warehouse-stock.component.css']
})

export class WarehouseStockComponent implements OnInit {

  @ViewChild('gaugeDashboard', {static:false})
  protected gaugeDashboard: OChartComponent;


  public gaugeDashboardConf: GaugeDashboardChartConfiguration;


  table_data = [{
    "stock": 0,
    "max_stock": 0,
    "percentage": 0
  }];
  chart_data = [
    {
      "stock":2242.068012820615,
      "max_stock":3138.895217948861,
      "percentage":71.42857142857143
    }
  ]
    
  constructor(
    
    ) {
      //const d3Locale = this.d3LocaleService.getD3LocaleConfiguration();
     }

  ngOnInit() {
  }
  
  
  ondataloaded(event){
    console.log(event);
    this.table_data[0].stock = event[0].stock;
    this.table_data[0].max_stock = event[1].stock;
    this.table_data[0].percentage = (event[0].stock/event[1].stock)*100;
    console.log(JSON.stringify(this.table_data));
    this._configureGaugeChart([{ 'x': 'ocupado', 'y': this.table_data[0].percentage }]);
  }
  
  private _configureGaugeChart(data): void {
    this.gaugeDashboardConf = new GaugeDashboardChartConfiguration();
    this.gaugeDashboardConf.title = data[0].y.toFixed(2) + "%";
    this.gaugeDashboardConf.yAxis = ['y'];
    this.gaugeDashboardConf.color = ['#17A589', 'white'];

    let adapter = DataAdapterUtils.createDataAdapter(this.gaugeDashboardConf);
    let dataAdapt = adapter.adaptResult(data);
    this.gaugeDashboard.setDataArray(dataAdapt);
    this.gaugeDashboard.setChartConfiguration(this.gaugeDashboardConf);
  }
}
