import { Injectable } from '@angular/core';
import { OTranslateService } from 'ontimize-web-ngx';
import { D3Locales } from './locales';

declare var d3: any;

@Injectable({
  providedIn: 'root'
})
export class D3LocaleService {

  constructor(
    private translateService: OTranslateService
  ) { }

  public getD3LocaleConfiguration(): any {
    const temp = D3Locales;
    return d3.locale(D3Locales['es'.toUpperCase()]);
  }
}
