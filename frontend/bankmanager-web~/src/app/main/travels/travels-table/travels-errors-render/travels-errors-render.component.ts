import { Component, OnInit, ViewChild, TemplateRef, Injector } from '@angular/core';
import { OBaseTableCellRenderer } from 'ontimize-web-ngx';

@Component({
  selector: 'app-travels-errors-render',
  templateUrl: './travels-errors-render.component.html',
  styleUrls: ['./travels-errors-render.component.css']
})
export class TravelsErrorsRenderComponent extends OBaseTableCellRenderer{

  @ViewChild('templateref', { read: TemplateRef, static: false }) public templateref: TemplateRef<any>;

  error_colors = {
    /*🔴🟠🟡🟢🔵🟣⚫️⚪️🟤*/
    measure : "🔴",
    not_out : "🔵",
    duration : "🟡"
  }

  constructor( protected injector: Injector) { 
    super(injector);
  }

  getCellData(cellvalue: any, rowvalue?: any): string{  
    return this.checkAnomalies(rowvalue);
  }

  checkAnomalies(rowData) : string{
    let errors = "";
        
    if(this.checkCheckout(rowData)){
      if(this.checkError(rowData.error)){   
        errors += this.error_colors.measure;
      }
      
      if(this.checkDuration(rowData.duration)){
        errors += this.error_colors.duration;
      }
      
    }else{
      errors += this.error_colors.not_out;
    }
    return errors;
    
  }
  
  checkError(error){
    return (error >= 10.0)? true: false;
  }
  checkDuration(duration){
    let duracion = duration.split(':');
    return (parseInt(duracion[0])>=1)? true: false;
  }
  checkCheckout(rowData){
    return (rowData.hasOwnProperty('datetime_out'))? true : false;
  }

}
