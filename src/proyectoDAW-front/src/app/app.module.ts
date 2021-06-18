import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { UserComponent } from './components/user/user.component';
import { StockComponent } from './components/stock/stock.component';
import { ClientComponent } from './components/client/client.component';
import { InvoicingComponent } from './components/invoicing/invoicing.component';
import { Globals } from './global';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { FacturacionComponent } from './components/facturacion/facturacion.component';
import { PedidosComponent } from './components/pedidos/pedidos.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    UserComponent,
    StockComponent,
    ClientComponent,
    InvoicingComponent,
    RegisterComponent,
    FacturacionComponent,
    PedidosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule { }
