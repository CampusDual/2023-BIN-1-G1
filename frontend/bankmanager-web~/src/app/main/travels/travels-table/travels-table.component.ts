import { Expression } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FilterExpressionUtils } from 'ontimize-web-ngx';

@Component({
  selector: 'app-travels-table',
  templateUrl: './travels-table.component.html',
  styleUrls: ['./travels-table.component.css']
})
export class TravelsTableComponent implements OnInit {

  stock:number;  
  constructor() { }

  ngOnInit() {
  }

  createFilter(values: Array<{attr,value}>): Expression{
    let filters = [];

    values.forEach(fila => {
      if(fila.value){
        if(fila.attr === "STARTDATE_I"){
          filters.push(FilterExpressionUtils.buildExpressionMoreEqual("datetime_in", fila.value));
        
        }if(fila.attr === "STARTDATE_E"){
          filters.push(FilterExpressionUtils.buildExpressionLessEqual("datetime_in", fila.value));
        
        }if(fila.attr === "ENDDATE_I"){
          filters.push(FilterExpressionUtils.buildExpressionMoreEqual("datetime_out", fila.value));
        
        }if(fila.attr === "ENDDATE_E"){
          filters.push(FilterExpressionUtils.buildExpressionLessEqual("datetime_out", fila.value));
        }
        
      }
    });

    if(filters.length > 0){
      return filters.reduce((exp1, exp2) => FilterExpressionUtils.buildComplexExpression(exp1, exp2, FilterExpressionUtils.OP_AND));
    
    }else return null;
  
  }

}
