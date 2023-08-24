import { Component, OnInit, ViewChild } from "@angular/core";
import {
  Expression,
  FilterExpressionUtils,
  OTranslateService,
} from "ontimize-web-ngx";
import {
  ChartService,
  DataAdapterUtils,
  DonutChartConfiguration,
  LineChartConfiguration,
  MultiBarChartConfiguration,
  OChartComponent,
} from "ontimize-web-ngx-charts";
import { D3LocaleService } from "../../../shared/d3locale.service";

@Component({
  selector: "app-travels-balance",
  templateUrl: "./travels-balance.component.html",
  styleUrls: ["./travels-balance.component.css"],
})
export class TravelsBalanceComponent {
  data = [];
  movements = [];
  values = {};

  @ViewChild("lineChart", { static: false })
  protected lineChart: OChartComponent;

  @ViewChild("multiBarChart", { static: false })
  protected multiBarChart: OChartComponent;

  @ViewChild("donutChart", { static: false })
  protected donutChart: OChartComponent;

  lineChartConf: LineChartConfiguration;
  lineChartBasic: any;

  donutChartConf: DonutChartConfiguration;
  donutChartBasic: any;

  multiBarChartConf: MultiBarChartConfiguration;
  multiChartBasic: any;

  constructor(
    private translateService: OTranslateService,
    private d3LocaleService: D3LocaleService
  ) {
    
  }
  ngOnInit() {
    this.translateService.onLanguageChanged.subscribe(() => {
      this.translate();
    });
  }

  ngAfterViewInit() {}

  onDataLoaded(event) {
    this.data = event.map((item) => {
      return { ...item, volume_out: item.volume_out * -1 };
    });
    this._configureMultiBarChart(this.data);
    this._configureDonutChart(this.data);
  }

  translate(){
    this._configureDonutChart(this.data);
    this._configureMultiBarChart(this.data);
  }

  private _configureDonutChart(data): void {
    this.movements = [
      {
        x: this.translateService.get("in"),
        y: data.reduce((a, movement) => (a += movement.volume_in), 0),
      },
      {
        x: this.translateService.get("out"),
        y: data.reduce((a, movement) => (a += movement.volume_out), 0) * -1,
      },
    ];
    this.values = {
      volume_in: this.movements[0].y.toFixed(2),
      volume_out: (this.movements[1].y * -1).toFixed(2),
    };

    this.donutChartConf = new DonutChartConfiguration();
    this.donutChartConf.color = ["#06d6a0", " #ef476f", "#0303b5"];
    this.donutChartConf.legendPosition = "top";
    this.donutChartConf.showLeyend = false;
    this.donutChartConf.cornerRadius = 7;
    this.donutChartConf.yAxis = ["y"];
    this.donutChartConf.yLabel = "x";
    this.donutChartConf.labelSunbeamLayout = false;
    this.donutChartConf.labelsOutside = false;
    this.donutChart.setDataArray(this.movements);
    this.donutChart.setChartConfiguration(this.donutChartConf);
    
  }

  private _configureMultiBarChart(data): void {
    this.multiBarChartConf = new MultiBarChartConfiguration();
    this.multiBarChartConf.color = ["#06d6a0", " #ef476f", "#0303b5"];
    this.multiBarChartConf.xAxis = "dia";
    this.multiBarChartConf.xDataType = "time";
    this.multiBarChartConf.yAxis = ["volume_in", "volume_out", "balance"];
    this.multiBarChartConf.yLabel = "Volume (m3)";
    this.multiBarChartConf.xLabel = "Date";
    this.multiBarChartConf.stacked = false;
    this.multiBarChartConf.showControls = false;

    let adapter = DataAdapterUtils.createDataAdapter(this.multiBarChartConf);
    let dataAdapt = adapter.adaptResult(data);
    (<any[]>dataAdapt).forEach((item) => {
      item.key = this.translateService.get(item.key);
    });
    this.multiBarChart.setDataArray(dataAdapt);
    this.multiBarChart.setChartConfiguration(this.multiBarChartConf);
  }
  createFilters(values: Array<{ attr: string; value: any[] }>): Expression {
    let filters = [];
    values.forEach((fila) => {
      if (fila.value) {
        if (fila.attr === "STARTDATE_I") {
          filters.push(
            FilterExpressionUtils.buildExpressionMoreEqual("dia", fila.value)
          );
        } else if (fila.attr === "STARTDATE_E") {
          filters.push(
            FilterExpressionUtils.buildExpressionLessEqual("dia", fila.value)
          );
        }
      }
    });

    if (filters.length > 0) {
      let expression = filters.reduce((exp1, exp2) =>
        FilterExpressionUtils.buildComplexExpression(
          exp1,
          exp2,
          FilterExpressionUtils.OP_AND
        )
      );
      return expression;
    } else return null;
  }
}
