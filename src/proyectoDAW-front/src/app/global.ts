import { Injectable } from '@angular/core';

@Injectable()
export class Globals {
    //https://proyecto-daw-back.herokuapp.com
    endPointServer: string = 'http://localhost:8080';
    //https://proyectodawfront.herokuapp.com
    urlFrontal: string = 'http://localhost:4200'
}