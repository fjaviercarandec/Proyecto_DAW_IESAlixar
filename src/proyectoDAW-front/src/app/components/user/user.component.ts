import { Component, OnInit } from '@angular/core';
import { Globals } from 'src/app/global';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  globals: Globals;
  idUser: any;
  nameUser: string;
  surnameUser: string;
  passUser: string;
  users: any;
  actives: any;

  constructor(globals: Globals, private userService: UserService) {
    this.globals = globals;
   }

  ngOnInit(): void {

    this.userService.getNoActiveUsers().subscribe((response) => {
      this.actives = response;
    });
  }

  getUser(): void {

    this.userService.getUser(this.idUser, this.nameUser, this.surnameUser).subscribe((response) => {
        console.table(response);
        this.users = response;
    });
  }

  activadoCorrecto(): void {
    Swal.fire(
      '¡Activado!',
      'El usuario ha sido activado.',
      'success'
    );
  }

  activadoIncorrecto(): void {
    Swal.fire(
      '¡Error!',
      'El usuario no ha podido ser activado',
      'error'
    );
  }

  validarUsuario(event) {
    let tupla = event.target.parentElement.parentElement;
    let idUsuario = tupla.childNodes[0].textContent;
    let isActivado: boolean;
    this.userService.activateUser(idUsuario).subscribe((response) => {
      isActivado = response;
      if(isActivado) {
        this.activadoCorrecto();
      } else {
        this.activadoIncorrecto();
      }
    });
  }

}
