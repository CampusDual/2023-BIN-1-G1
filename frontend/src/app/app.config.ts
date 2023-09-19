import { Config } from 'ontimize-web-ngx';

import { MENU_CONFIG } from './shared/app.menu.config';
import { SERVICE_CONFIG } from './shared/app.services.config';

export const CONFIG: Config = {
  // The base path of the URL used by app services.
  //apiEndpoint: 'https://8sjt10p6-33333.uks1.devtunnels.ms',
  apiEndpoint: 'http://localhost:30072',
  uuid: 'com.ontimize.web.ngx.jee.seed',
  title: 'Truck Logistic',
  locale: 'en',
  serviceType: 'OntimizeEE',
  servicesConfiguration: SERVICE_CONFIG,
  appMenuConfiguration: MENU_CONFIG,
  applicationLocales: ['es', 'en'],

  bundle: {
    path: 'login'

  },
  permissionsServiceType: 'OntimizeEEPermissions',
  permissionsConfiguration: {
    service: 'permissions'

  },
  exportConfiguration: {
    path: '/export'
  }
};
