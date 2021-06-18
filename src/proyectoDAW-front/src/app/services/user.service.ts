import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../global';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  endPointServer: string;

  constructor(private http: HttpClient, private globals: Globals) { 
    this.endPointServer = globals.endPointServer;
  }

  getUser(usuarioid: any, usuarioname: string, usuariosurname: string): Observable<any> {
    const endPoint = this.endPointServer + '/user/getUser';
    return this.http.post<any>(endPoint, { 
      id: usuarioid,
      name: usuarioname,
      surname: usuariosurname
    });
  }

  getNoActiveUsers(): Observable<any> {
    const endPoint = this.endPointServer + '/user/noActiveUsers';
    return this.http.get<any>(endPoint);
  }

  activateUser(idUsuario: number): Observable<any> {
    const endPoint = this.endPointServer + '/user/activateUser';
    return this.http.post<any>(endPoint, {
      idUser: idUsuario
    });
  }

  login(email: string, password: string): Observable<any> {
    const endPoint = this.endPointServer + '/user/login';
    return this.http.post<any>(endPoint, {
      email: email,
      password: password
    });
  }

  signIn(nombre: string, apellido: string, telefono: string, email: string, password: string) {
    const endPoint = this.endPointServer + '/user/register';
    return this.http.post<any>(endPoint, {
      name: nombre,
      surnames: apellido,
      phone: telefono,
      email: email,
      password: password
    });
  }
}
