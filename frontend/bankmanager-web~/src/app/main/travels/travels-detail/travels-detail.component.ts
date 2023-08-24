import { ChangeDetectorRef, Component, ElementRef, OnInit, QueryList, ViewChildren } from '@angular/core';

@Component({
  selector: 'app-travels-detail',
  templateUrl: './travels-detail.component.html',
  styleUrls: ['./travels-detail.component.css']
})
export class TravelsDetailComponent implements OnInit {

  @ViewChildren('num') numElements: QueryList<ElementRef>;
  
  allData: boolean;
  data = {
      "travel_info": {
        "datetime_in": null,
        "datetime_out": null,
        "duration":null,
        "delivery_name": null,
        "id_travel": null,
        "plate_number": null,
        "trailer_plate_number": null,
        "occupation": null,
      },
      "measure_info": {
        "scan_volume_in": null,
        "scan_volume_out": null,    
        "length": null,
        "width": null,
        "height": null,
        "calculated_volume" : null,
        "difference" : null,
        "error": null
      }
  };
  travel_info_keys = [];
  measure_info_keys = [];

  constructor() { }

  ngOnInit() {
    
  }  


  get dataKeys(){
    return Object.keys(this.data);
  }

  getData(event){   
    this.setData(event.hasOwnProperty("datetime_out"), event);
      
    console.log(this.data.travel_info.duration);
    console.log(typeof event.duration);
    this.measure_info_keys = Object.keys(this.data.measure_info);
    this.travel_info_keys = Object.keys(this.data.travel_info);
    this.animateCounterNumbers(event.hasOwnProperty("datetime_out"));
  }
  
  get travelInfoKeys(){
    if(this.data == undefined || this.data.travel_info == undefined)
      return []
    return Object.keys(this.data.travel_info)
  }

  get measureInfoKeys(){
    if(this.data == undefined || this.data.measure_info == undefined)
      return []
    return Object.keys(this.data.measure_info)
  }
  
  getDateInFormat(date:Date){

    const day = String(date.getDate()).padStart(2,'0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = String(date.getFullYear()).padStart(2,'0');
    const hour = String(date.getHours()).padStart(2,'0');
    const minutes = String(date.getMinutes()).padStart(2,'0');
    return `${day}/${month}/${year} ${hour}:${minutes}`;
  }

  setData(isFullData:boolean, event){
    if(isFullData){
      this.allData = true;
      this.data = { 
        travel_info:{
          id_travel : event.id_travel,
          datetime_in : this.getDateInFormat(new Date(event.datetime_in)),
          datetime_out : this.getDateInFormat(new Date(event.datetime_out)),
          duration: event.duration,
          delivery_name : event.delivery_name,
          plate_number : event.plate_number,
          trailer_plate_number : event.trailer_plate_number,
          occupation: Math.round(event.occupation * 100)/100
        }, 
        measure_info:{
          scan_volume_in: Math.round(event.scan_volume_in * 100) / 100,
          scan_volume_out: Math.round(event.scan_volume_out * 100) / 100,
          calculated_volume: Math.round(event.calculated_volume * 100) / 100,
          length: Math.round(event.length * 100) / 100,
          height: Math.round(event.height * 100) / 100,
          width: Math.round(event.width * 100) / 100,
          difference: Math.round(event.difference * 100)/100,
          error: Math.round(event.error * 100)/100
        }
      }

    }else{
      this.allData = false;
      this.data = { 
        travel_info:{
          id_travel : event.id_travel,
          datetime_in : this.getDateInFormat(new Date(event.datetime_in)),
          datetime_out : "",
          duration: "",
          delivery_name : event.delivery_name,
          plate_number : event.plate_number,
          trailer_plate_number : event.trailer_plate_number,
          occupation: ""
        }, 
        measure_info:{
          scan_volume_in: Math.round(event.scan_volume_in * 100) / 100,
          scan_volume_out: "",
          calculated_volume: "",
          length: Math.round(event.length * 100) / 100,
          height: Math.round(event.height * 100) / 100,
          width: Math.round(event.width * 100) / 100,
          difference: "",
          error: ""
        }
      }
    }
  }


  convertMillisecondsToHoursMinutesSeconds(milliseconds) {
    // Convertimos los milisegundos a segundos
    let seconds = (milliseconds / 1000);
  
    // Dividimos los segundos en horas, minutos y segundos
    let hours = Math.floor(seconds / 3600);
    let minutes = Math.floor((seconds % 3600) / 60);
    seconds = seconds % 60;
  
    // Devolvemos los resultados
    return `${hours}:${minutes}:${seconds}`
  }
  
  animateCounterNumbers(isFullMeasures: boolean){
    const posibleNulls = ['scan_volume_out', 'calculated_volume'];
    const animationDuration = [200, 700, 1200]; // Duración total de la animación en milisegundos
  
    this.numElements.forEach((elementRef: ElementRef) => {
      const element = elementRef.nativeElement;
      const startValue = 0;
      const endValue = this.data['measure_info'][element.getAttribute("data-val")];
      const steps = 100; // Número de pasos para la animación
      const stepValue = (endValue - startValue) / steps; // Valor a incrementar en cada paso
      const index = Math.floor(Math.random() * 3);
      const interval = animationDuration[index] / steps; // Intervalo de tiempo para cada paso
  
      let currentValue = startValue;
      let stepCounter = 0;
  
      const counter = setInterval(() => {
        currentValue += stepValue;
        if(!isFullMeasures && posibleNulls.some(clave => element.getAttribute("data-val") == clave)){
            element.textContent = "";
        }else {
          element.textContent = currentValue.toFixed(2);
        }
  
        stepCounter++;
        if (stepCounter >= steps || currentValue >= endValue) {
          clearInterval(counter);
        }
      }, interval);
    });

  }
}
