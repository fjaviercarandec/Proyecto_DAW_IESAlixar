import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BalanceService {

  constructor(private http: HttpClient) { }

  getBalance(mes: string, anyo: number): Observable<any> {
    const endPoint = 'http://localhost:8080/';
    return this.http.post<any>(endPoint, {
      month: mes,
      year: anyo
    });
  }

}
