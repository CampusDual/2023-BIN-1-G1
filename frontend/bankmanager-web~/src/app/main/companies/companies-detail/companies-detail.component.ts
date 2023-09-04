import { Component, OnInit, ViewChild } from '@angular/core';
import { OFormComponent } from 'ontimize-web-ngx';

@Component({
  selector: 'app-companies-detail',
  templateUrl: './companies-detail.component.html',
  styleUrls: ['./companies-detail.component.css']
})
export class CompaniesDetailComponent implements OnInit {
  @ViewChild('formDetailCompanies', {static:false})
  protected formDetailCompanies: OFormComponent;
  constructor() { }

  ngOnInit() {
  }

  
}
