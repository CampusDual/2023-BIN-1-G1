import { Expression } from '@angular/compiler';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FilterExpressionUtils } from 'ontimize-web-ngx';

@Component({
  selector: 'app-travels-table',
  templateUrl: './travels-table.component.html',
  styleUrls: ['./travels-table.component.css']
})
export class TravelsTableComponent implements OnInit {
  stock:number;  
 
  constructor(private cd: ChangeDetectorRef) { }



  ngOnInit() {

  }

  ngAfterViewInit() {
    this.cd.detectChanges();
  }

  createFilters(values: Array<{attr: string,value: any[]}>): Expression{
    let filters = [];
    values.forEach(fila => {
      if (fila.value) {
        if (fila.attr === "STARTDATE_I") {
          filters.push(FilterExpressionUtils.buildExpressionMoreEqual("datetime_in", fila.value));
        } else if (fila.attr === "STARTDATE_E") {
          filters.push(FilterExpressionUtils.buildExpressionLessEqual("datetime_in", fila.value));
        } else if (fila.attr === "PLATENUMBER") {
          let filters_matricula = []
          if (fila.value.length > 0){       
            fila.value.forEach((plate:any) => {
              filters_matricula.push( FilterExpressionUtils.buildExpressionEquals("plate_number", plate))
            });
            filters.push(
              filters_matricula.reduce(
                (exp1, exp2) => FilterExpressionUtils.buildComplexExpression(exp1,exp2, FilterExpressionUtils.OP_OR)
              )              
            );          
          }    
        }
      }
    });
    
    if (filters.length > 0) {
      let expression = filters.reduce(
        (exp1, exp2) => FilterExpressionUtils.buildComplexExpression(exp1, exp2, FilterExpressionUtils.OP_AND)
      ); 
      return expression;
    }else return null;
  
  }

  convertDuration(rowData:any):any[]{
    
    let duracion = rowData.duration;
    if(duracion){
      //return `${duracion.hours}:${duracion.minutes}:${duracion.seconds}`
      return ["5"];
    }
    else{
      return [];
    }
  }

}
