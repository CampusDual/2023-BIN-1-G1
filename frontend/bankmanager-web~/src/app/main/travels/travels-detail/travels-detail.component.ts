import { ChangeDetectorRef, Component, ElementRef, OnInit, QueryList, ViewChildren } from '@angular/core';

@Component({
  selector: 'app-travels-detail',
  templateUrl: './travels-detail.component.html',
  styleUrls: ['./travels-detail.component.css']
})
export class TravelsDetailComponent implements OnInit {

  @ViewChildren('num') numElements: QueryList<ElementRef>;
  
  
  data = {
      "travel_info": {
        "datetime_in": null,
        "datetime_out": null,
        "delivery_name": null,
        "id_travel": null,
        "plate_number": null,
        "trailer_plate_number": null,
      },
      "measure_info": {
        "scan_volume_in": null,
        "scan_volume_out": null,    
        "length": null,
        "width": null,
        "height": null,
        "calculated_volume" : null,
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
    console.log(event);
    this.data = { 
      travel_info:{
        id_travel : event.id_travel,
        datetime_in : this.getDateInFormat(new Date(event.datetime_in)),
        datetime_out : this.getDateInFormat(new Date(event.datetime_out)),
        delivery_name : event.delivery_name,
        plate_number : event.plate_number,
        trailer_plate_number : event.trailer_plate_number,
      }, 
      measure_info:{
        scan_volume_in: Math.round(event.scan_volume_in * 100) / 100,
        scan_volume_out: Math.round(event.scan_volume_out * 100) / 100,
        calculated_volume: Math.round(event.calculated_volume * 100) / 100,
        length: Math.round(event.length * 100) / 100,
        height: Math.round(event.height * 100) / 100,
        width: Math.round(event.width * 100) / 100,

      }
    }
    this.measure_info_keys = Object.keys(this.data.measure_info);
    this.travel_info_keys = Object.keys(this.data.travel_info);
    this.animateCounterNumbers();
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
  
  animateCounterNumbers(){
    console.log("HE ENTRADO");
    const animationDuration = [500, 1000, 2000]; // Duración total de la animación en milisegundos
  
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
        element.textContent = currentValue.toFixed(2);
  
        stepCounter++;
        if (stepCounter >= steps || currentValue >= endValue) {
          clearInterval(counter);
        }
      }, interval);
    });

  }
}
