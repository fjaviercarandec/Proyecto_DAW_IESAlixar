import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityuserGuard } from 'src/app/guards/securityuser.guard'
import { SecurityadminGuard } from 'src/app/guards/securityadmin.guard';

const routes: Routes = [
  {
    path: 'user',
    loadChildren: () => import('./components/user/user.module').then((m) => m.UserModule),
    canActivate: [SecurityadminGuard],
  },
  {
    path: 'client',
    loadChildren: () => import('./components/client/client.module').then((m) => m.ClientModule),
    canActivate: [SecurityuserGuard],
  },
  {
    path: 'invoicing',
    loadChildren: () => import('./components/invoicing/invoicing.module').then((m) => m.InvoicingModule),
    canActivate: [SecurityadminGuard],
  },
  {
    path: 'stock',
    loadChildren: () => import('./components/stock/stock.module').then((m) => m.StockModule),
    canActivate: [SecurityuserGuard],
  },
  {
    path: 'facturacion',
    loadChildren: () => import('./components/facturacion/facturacion.module').then((m) => m.FacturacionModule),
    canActivate: [SecurityuserGuard],

  },
  {
    path: 'register',
    loadChildren: () => import('./components/register/register.module').then((m) => m.RegisterModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
