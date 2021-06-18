import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Globals } from '../global';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  endPointServer: string;

  constructor(private http: HttpClient, private globals: Globals) {
    this.endPointServer = globals.endPointServer;
   }

  addProduct(nombre: string, cantidad: number, talla: string, color: string, descripcion: string) {
    const endPoint = this.endPointServer + '/product/addProduct';
    return this.http.post<any>(endPoint, {
      name: nombre,
      quantity: cantidad,
      size: talla,
      color: color,
      description: descripcion
    });
  }

  searchProducts(idProducto: number, nombre: string, color: string) {
    const endPoint = this.endPointServer + '/product/searchProduct';
    return this.http.post<any>(endPoint, {
      idProduct: idProducto,
      name: nombre,
      color: color,
    });
  }

  deleteProduct(idProducto: number) {
    const endPoint = this.endPointServer + '/product/deleteProduct'
    return this.http.post<any>(endPoint, {
      idProduct: idProducto
    })
  }

  updateProduct(idProducto: number, nombre: string, cantidad: number, talla: string, color: string) {
    const endPoint = this.endPointServer + '/product/updateProduct'
    return this.http.post<any>(endPoint, {
      idProduct: idProducto,
      name: nombre,
      quantity: cantidad,
      size: talla,
      color: color
    });
  }

  addSaleToClient(idCliente: number, saleDetails: any) {
    const endPoint = this.endPointServer + '/client/addSaleToClient';
    return this.http.post<any>(endPoint, {
      idClient: idCliente,
      sales: {
        saleDetails: saleDetails
      }
    });
  }
}
