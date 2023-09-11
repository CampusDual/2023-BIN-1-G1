import { Component, OnInit } from '@angular/core';
import { OTranslateService } from 'ontimize-web-ngx';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-companies-balance',
  templateUrl: './companies-balance.component.html',
  styleUrls: ['./companies-balance.component.css']
})
export class CompaniesBalanceComponent implements OnInit {

  data: any[];
  bestBuyers: any[];
  bestSellers: any[]; 
  public chart: any;
  constructor(private translateService: OTranslateService) {

  }

  ngOnInit() {
    this.translateService.onLanguageChanged.subscribe(() => {

    });
    
  }

  onDataLoaded(event){
    this.data = event;
    this.createChart();
  }
  onDataLoadedBuyers(event){
    this.bestBuyers = event;
    this.bestBuyers = this.bestBuyers.map(item => {
      if(item.company_logo){
        const base64Image: string = item.company_logo.bytes;
        const imageUrl: string = `data:image/jpeg;base64,${base64Image}`;

        return {...item, company_logo: imageUrl} 
      }else{
        return {...item, company_logo: "./assets/images/no-image.png"}
      }
    })
    
  }
  onDataLoadedSellers(event){
    this.bestSellers = event;
    this.bestSellers = this.bestSellers.map(item => {
      if(item.company_logo){
        const base64Image: string = item.company_logo.bytes;
        const imageUrl: string = `data:image/jpeg;base64,${base64Image}`;

        return {...item, company_logo: imageUrl} 
      }else{
        return {...item, company_logo: "./assets/images/no-image.png"}
      }
    })
  }

  createChart(){

    new Chart(
      "numTravelsChart",
      {
        type: "pie",
        data: {
          labels: this.data.map(row => row.company_name),          
          datasets: [
            {
              label: this.translateService.get("num_travels"),
              data: this.data.map(row => row.num_travels),
              backgroundColor: this.generarColoresHex(this.data.length),
            }
          ],                  
        },
        options: {
          legend: {
            display: false
          },
          aspectRatio: 1.4/1
        }
      }

    );  
  };
  
  generarColoresHex(numeroColores) {
    const tonoInicial = [239, 71, 111];  // Tono rojo pastel fuerte RGB
    const tonoFinal = [255, 235, 59];    // Tono amarillo pastel fuerte RGB
    
    const colores = [];
    for (let i = 0; i < numeroColores; i++) {
        const r = Math.floor(tonoInicial[0] + (tonoFinal[0] - tonoInicial[0]) * (i / (numeroColores - 1)));
        const g = Math.floor(tonoInicial[1] + (tonoFinal[1] - tonoInicial[1]) * (i / (numeroColores - 1)));
        const b = Math.floor(tonoInicial[2] + (tonoFinal[2] - tonoInicial[2]) * (i / (numeroColores - 1)));
        
        const color = "#" + (r << 16 | g << 8 | b).toString(16).padStart(6, '0');
        colores.push(color);
    }
    
    return colores;
  }
}
