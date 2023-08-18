import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  //{ id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'travels-data', name:'TRAVELS', icon:'local_shipping', opened:true,
    items: [
      { 
        id:'travels-list', 
        name:'travels_list', 
        tooltip:'TRAVELS_CONTENT', 
        route:'main/travels/travels-list', 
        icon:'list'
      },
      { 
        id: 'travels-balance', 
        name:'travels_balance', 
        tooltip:'TRAVELS_BALANCE_CONTENT', 
        route:'main/balance-travels/travels-balance', 
        icon: 'balance'
      }
    ]
  
  },
  { id: 'warehouse', name: 'WAREHOUSE', icon: 'warehouse', route: '/main/warehouse'},
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
