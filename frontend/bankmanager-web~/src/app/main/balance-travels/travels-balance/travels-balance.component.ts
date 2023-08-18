import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartService, DataAdapterUtils, LineChartConfiguration, MultiBarChartConfiguration, OChartComponent } from 'ontimize-web-ngx-charts';

@Component({
  selector: 'app-travels-balance',
  templateUrl: './travels-balance.component.html',
  styleUrls: ['./travels-balance.component.css']
})
export class TravelsBalanceComponent  {
  data = [];


  @ViewChild('lineChart', {static:false})
  protected lineChart: OChartComponent;

  @ViewChild('multiBarChart', {static:false})
  protected multiBarChart: OChartComponent;


  lineChartConf: LineChartConfiguration;
  lineChartBasic: any;

  multiBarChartConf: MultiBarChartConfiguration;
  multiChartBasic: any;
  constructor() {
   
  }
  ngOnInit(){}

  ngAfterViewInit() {
    

  }
  onDataLoaded(event){
    this.data = event.map(item => {
      item.volume_out *= 1
      return item;
    });
    
    /*
    this.data = this.data.map(item => {
      item.dia = new Date(item.dia);
      item.dia = item.dia.toLocaleString("es-ES", {dateStyle: "medium"});
      return item;
    });
    */
   //this._configureLineChart(this.data);
    this._configureMultiBarChart(this.data);
  }
  private _configureMultiBarChart(data): void {
    this.multiBarChartConf = new MultiBarChartConfiguration();
    this.multiBarChartConf;
    //this.multiBarChartConf.isArea = [false];
    //this.multiBarChartConf.interactive = false;
    //this.multiBarChartConf.useInteractiveGuideline = true;
    this.multiBarChartConf.color = ["#06d6a0"," #ef476f","#0303b5"];
    //this.multiBarChartConf.legendPosition = "right";
    this.multiBarChartConf.xAxis = "dia";
    this.multiBarChartConf.xDataType = "time";
    this.multiBarChartConf.yAxis = ["volume_in","volume_out","balance"];
    this.multiBarChartConf.yLabel = "Volume (m3)";
    this.multiBarChartConf.xLabel = "Date";
  
    
    let adapter = DataAdapterUtils.createDataAdapter(this.multiBarChartConf);
    let dataAdapt = adapter.adaptResult(data);
    this.multiBarChart.setDataArray(dataAdapt);
    this.multiBarChart.setChartConfiguration(this.multiBarChartConf);
    
    /*
    this.gaugeDashboardConf = new GaugeDashboardChartConfiguration();
    this.gaugeDashboardConf.title = data[0].y.toFixed(2) + "%";
    this.gaugeDashboardConf.yAxis = ['y'];
    this.gaugeDashboardConf.color = ['#17A589', 'white'];

    */

  }
  private _configureLineChart(data): void {
    this.lineChartConf = new LineChartConfiguration();
    this.lineChartConf;
    this.lineChartConf.isArea = [false];
    this.lineChartConf.interactive = false;
    this.lineChartConf.useInteractiveGuideline = true;
    this.lineChartConf.color = ["#06d6a0"," #ef476f","#0303b5"];
    this.lineChartConf.legendPosition = "right";
    this.lineChartConf.xAxis = "dia";
    this.lineChartConf.xDataType = "time";
    this.lineChartConf.yAxis = ["volume_in","volume_out","balance"];
    this.lineChartConf.yLabel = "Volume (m3)";
    this.lineChartConf.xLabel = "Date";
  
    
    let adapter = DataAdapterUtils.createDataAdapter(this.lineChartConf);
    let dataAdapt = adapter.adaptResult(data);
    
    this.lineChart.setDataArray(dataAdapt);
    this.lineChart.setChartConfiguration(this.lineChartConf);
    
    /*
    this.gaugeDashboardConf = new GaugeDashboardChartConfiguration();
    this.gaugeDashboardConf.title = data[0].y.toFixed(2) + "%";
    this.gaugeDashboardConf.yAxis = ['y'];
    this.gaugeDashboardConf.color = ['#17A589', 'white'];

    */

  }
}

