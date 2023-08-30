import { Component, OnInit } from '@angular/core';
import { OTranslateService } from 'ontimize-web-ngx';

@Component({
  selector: 'app-companies-new',
  templateUrl: './companies-new.component.html',
  styleUrls: ['./companies-new.component.css']
})
export class CompaniesNewComponent implements OnInit {
  countries: any[] = [
    {id: 1, name:"Spain"},
    {id: 2, name:"Portugal"},
    {id: 3, name:"France"},
    {id: 4, name:"United States"},
    {id: 5, name:"United Kingdom"},
    {id: 6, name:"Germany"}
  ];

  countries_translated: any[];

  constructor(){}

  ngOnInit(){}

  

}
