import { Injectable } from '@angular/core';
import { OTranslateService } from 'ontimize-web-ngx';
import { D3Locales } from './locale';

declare var d3: any;

@Injectable({
  providedIn: 'root'
})
export class D3localeService {

  constructor(
    private translateService: OTranslateService
  ) { }
}
