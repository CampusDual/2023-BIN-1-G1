import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  //{ id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'travels-data', name:'TRAVELS', icon:'sync_alt', 
  items: [
    { 
      id:'travels-list', 
      name:'travels_list', 
      route:'/main/travels', 
      icon:'list'
    },
    { 
      id: 'travels-balance', 
      name:'travels_balance', 
      route:'/main/balance-travels', 
      icon: 'balance'
    },
      { 
      id: 'trucks', 
      name:'movements', 
      route:'/main/trucks', 
       icon: 'local_shipping'
      }
    ]
    
  },
  { id: 'warehouse', name: 'WAREHOUSE', icon: 'warehouse', route: '/main/warehouse'},
  { id: 'companies', name: 'COMPANIES', icon: 'factory', 
  items: [
    {
      id:'companies-list',
      name: 'companies_list',
      route: '/main/companies',
      icon: 'list'
    },
    {
      id:'companies-balance',
      name: 'companies_balance',
      route: '/main/companies-balance',
      icon: 'balance'
    }
  ]},
  { id: 'travelsByUser', name: 'TRAVELSBYUSER', route: '/main/travels-by-user', icon: 'space_dashboard'},
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
