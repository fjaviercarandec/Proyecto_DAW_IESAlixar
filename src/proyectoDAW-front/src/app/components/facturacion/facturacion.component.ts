import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/services/client.service';
import { StockService } from 'src/app/services/stock.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-facturacion',
  templateUrl: './facturacion.component.html',
  styleUrls: ['./facturacion.component.css']
})
export class FacturacionComponent implements OnInit {

  idClient: number;
  nombreClient: string;
  apellidoClient: string;
  clients: any;

  clienteSeleccionado: boolean = false;
  idClienteSeleccionado: number;
  nombreClienteSeleccionado: string;
  apellidoClienteSeleccionado: string;

  idProducto: number;
  nombreProducto: string;
  colorProducto: string;
  productos: any;

  productoSeleccionado: boolean;
  idProductoSeleccionado: number;
  nombreProductoSeleccionado: string;
  tallaProductoSeleccionado: string;
  colorProductoSeleccionado: string;
  cantidadProductoSeleccionado: number;
  listaProductoSeleccionado: any = [];

  listaSaleDetails: any = [];

  productosCliente: any;

  constructor(private clientService: ClientService, private stockService: StockService) { }

  ngOnInit(): void {
  }

  getClient(): void {
    this.clientService.getClient(this.idClient, this.nombreClient, this.apellidoClient).subscribe((response) => {
      this.clients = response;
    })
  }

  searchProducts():void {
    this.stockService.searchProducts(this.idProducto, this.nombreProducto, this.colorProducto).subscribe((response) => {
      this.productos = response;
    });
  }

  selectCliente(event): void {
    let tupla = event.target.parentElement.parentElement;
    this.idClienteSeleccionado = tupla.childNodes[0].textContent;
    this.nombreClienteSeleccionado = tupla.childNodes[1].textContent;
    this.apellidoClienteSeleccionado = tupla.childNodes[2].textContent;
    this.clienteSeleccionado = true;
  }

  addProducto(event) {
    let tupla = event.target.parentElement.parentElement;
    this.idProductoSeleccionado = tupla.childNodes[0].textContent;
    this.nombreProductoSeleccionado = tupla.childNodes[1].textContent;
    this.tallaProductoSeleccionado = tupla.childNodes[3].textContent;
    this.colorProductoSeleccionado = tupla.childNodes[4].textContent;
    this.cantidadProductoSeleccionado = tupla.childNodes[5].firstChild.value;
    this.productoSeleccionado = true;
    let producto = {
      id: this.idProductoSeleccionado,
      nombre: this.nombreProductoSeleccionado,
      talla: this.tallaProductoSeleccionado,
      color: this.colorProductoSeleccionado,
      cantidad: this.cantidadProductoSeleccionado
    }
    let saleDetails = {
      quantity: this.cantidadProductoSeleccionado,
      idProduct: this.idProductoSeleccionado
    }
    this.listaProductoSeleccionado.push(producto);
    this.listaSaleDetails.push(saleDetails);
    console.log(tupla.childNodes[5].firstChild.value);
    console.table(this.listaProductoSeleccionado);
  }

  addSaleCorrect(): void {
    Swal.fire(
      '¡Añadido!',
      'La venta ha sido efectuada.',
      'success'
    )
  }

  addSaleIncorrect(): void {
    Swal.fire(
      '¡Error!',
      'Ha ocurrido un error al realizar la venta.',
      'error'
    )
  }

  addVenta(): void {
    this.stockService.addSaleToClient(this.idClienteSeleccionado, this.listaSaleDetails).subscribe((response) => {
      let addSaleControl = response;
      if(addSaleControl) {
        this.addSaleCorrect();
        this.listaProductoSeleccionado = [];
        this.listaSaleDetails = [];
      } else {
        this.addSaleIncorrect();
        this.listaProductoSeleccionado = [];
        this.listaSaleDetails = [];
      }
    })
  }

  borrarProdCarrito(event) {
    let tupla = event.target.parentElement.parentElement;
    let padre = event.target.parentElement.parentElement.parentElement;
    console.log(padre);
  }

}
