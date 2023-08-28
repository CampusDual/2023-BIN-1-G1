import { Component, Input, OnInit, ElementRef, QueryList, ViewChildren, AfterViewInit, OnChanges } from '@angular/core';

@Component({
  selector: 'card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit, OnChanges{

  @Input() iconName: string = '';          // Nombre del icono
  @Input() content: string = '';           // Contenido del componente
  @Input() animate: boolean = false;       // Indicador de animaciÓn
  @Input() data;                      // Datos que recibe el componente
  /*@Input() iconBackground : string = "#e85d04";   // Color de fondo de los iconos*/
  @Input() iconBackground : string = "#FEE2D8";
  @Input() allData: boolean = true;        // Clase de la unidad de medida (m, m3, %)
  @Input() isMeters: boolean = false;
  @Input() isPercent: boolean = false;
  @Input() isCubics: boolean = false;
  @Input() isNumber: boolean = false;
  
  valueToShow;
  
  ngOnInit() {
  }
  
  ngOnChanges(){
    if(this.animate){
      if(this.data){
        this.animateCounterNumbers(this.allData);
      }
    }
  }
  

  animateCounterNumbers(isFullMeasures: boolean){
    const posibleNulls = ['scan_volume_out2', 'calculated_volume2'];
    const animationDuration = [200, 700, 1200];
    const startValue = 0;
    const endValue = this.data;
    const steps = 100; // Número de pasos para la animación
    const stepValue = (endValue - startValue) / steps; // Valor a incrementar en cada paso
    const index = Math.floor(Math.random() * 3);
    const interval = animationDuration[index] / steps; // Intervalo de tiempo para cada paso
  
    let currentValue = startValue;
    let stepCounter = 0;
  
    const counter = setInterval(() => {
      currentValue += stepValue;
      if(!isFullMeasures && posibleNulls.some(clave => this.content == clave)){
          this.valueToShow = "";
      }else {
          this.valueToShow = currentValue;
      }
    
      stepCounter++;
      if (stepCounter >= steps || currentValue >= endValue) {
        clearInterval(counter);
      }
    }, interval);
  }
  /*
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
  */
}