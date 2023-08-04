import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  //{ id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'travels', name:'TRAVELS', icon:'local_shipping', route: '/main/travels'},
  { id: 'warehouse', name: 'WAREHOUSE', icon: 'warehouse', route: '/main/warehouse'},
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
