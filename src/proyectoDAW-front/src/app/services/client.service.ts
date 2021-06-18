import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Globals } from '../global';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  endPointServer: string;

  constructor(private http: HttpClient, private globals: Globals) {
    this.endPointServer = globals.endPointServer;
   }

  getClient(idClient: any, nombreClient: string, apellidoClient: string) {
    const endPoint = this.endPointServer + '/client/getClient';
    return this.http.post<any>(endPoint, {
      id: idClient,
      name: nombreClient,
      surname: apellidoClient
    });
  }

  deleteClient(idCliente: number) {
    const endPoint = this.endPointServer + '/client/deleteClient'
    return this.http.post<any>(endPoint, {
      idClient: idCliente
    })
  }

}
