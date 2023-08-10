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

  createFilters(values: Array<{attr,value}>): Expression{
    let filters = [];
    console.log(values);
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
        
        }if(fila.attr === "PLATENUMBER"){
          filters.push(FilterExpressionUtils.buildExpressionEquals("plate_number", fila.value));
          
        }
      }
    });

    if(filters.length > 0){
      let expression = filters.reduce((exp1, exp2) => FilterExpressionUtils.buildComplexExpression(exp1, exp2, FilterExpressionUtils.OP_AND)); 
      console.log(expression);
      return expression;
    }else return null;
  
  }

  reloadAll(){
    console.log("hola");
    window.location.reload();
  }
  /*filterByPlates(values){
    let filters = [];
    let plates = values.attr
    if(plates){
      plates.forEach( plate => {
        filters.push(FilterExpressionUtils.buildExpressionEquals("plate_number", plate));
      });
    }
    if(filters.length > 0){
      return filters.reduce((exp1, exp2) => FilterExpressionUtils.buildComplexExpression(exp1, exp2, FilterExpressionUtils.OP_OR));
    }else return null;
  }*/

}
