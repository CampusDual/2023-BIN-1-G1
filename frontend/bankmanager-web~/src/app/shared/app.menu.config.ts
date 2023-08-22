import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  //{ id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'warehouse', name: 'WAREHOUSE', icon: 'warehouse', route: '/main/warehouse'},
  { id: 'travels-data', name:'TRAVELS', icon:'sync_alt', 
    items: [
      { 
        id:'travels-list', 
        name:'travels_list', 
        //tooltip:'TRAVELS_CONTENT', 
        route:'/main/travels/travels-list', 
        icon:'list'
      },
      { 
        id: 'travels-balance', 
        name:'travels_balance', 
        //tooltip:'TRAVELS_BALANCE_CONTENT', 
        route:'/main/balance-travels', 
        icon: 'balance'
      },
      { 
        id: 'trucks', 
        name:'trucks', 
        //tooltip:'TRUCKS_CONTENT', 
        route:'/main/trucks', 
        icon: 'local_shipping'
      }
    ]
  
  },
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
