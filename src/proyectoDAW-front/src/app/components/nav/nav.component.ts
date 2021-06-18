import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  userName: string;
  pass: string;
  isLogin: boolean;
  user: any;

  constructor(private userService: UserService) {
    this.user = sessionStorage.getItem('userName');
    if(sessionStorage.getItem('isLogin') == 'true') {
      this.isLogin = true;
    } else {
      this.isLogin = false;
    }
   }

  ngOnInit(): void {
  }

  swalCorrecto(): void {
    Swal.fire('¡Login correcto!', '', 'success');
  }

  swalIncorrecto(): void {
    Swal.fire('¡Error!', 'El email o la contraseña son incorrectos.', 'error');
  }

  swalUserNoActivo(): void {
    Swal.fire('¡Error!', 'Usuario no activo.', 'error')
  }


  async login() {
    const res = await Swal.fire({
      title: 'Login',
      html: 
        '<label>Email:</label><br>' +
        '<input id="swal-input1" class="swal2-input">' +
        '<label>Contraseña:</label><br>' +
        '<input type="password" id="swal-input2" class="swal2-input"><br>' +
        '<a href="http://localhost:4200/register">Registrate</a>',
      focusConfirm: false,
      preConfirm: () => {
        this.userName = (document.getElementById("swal-input1") as HTMLInputElement).value;
        this.pass = (document.getElementById("swal-input2") as HTMLInputElement).value;
      }
    });

    if(res) {
      this.userService.login(this.userName, this.pass).subscribe((response) => {
        console.table(response);
        this.user = response.name;
        console.log(response.admin);
        console.log(this.user);
        if(this.user != null) {
          if(response.active) {
            this.isLogin = true;
            sessionStorage.setItem('userName', this.user);
            sessionStorage.setItem('password', this.pass);
            sessionStorage.setItem('isLogin', "true");
            if(response.admin) {
              sessionStorage.setItem('isAdmin', "true");
            }
            this.swalCorrecto();
          } else {
            this.isLogin = false;
            this.swalUserNoActivo();
          }
        } else {
          this.isLogin = false;
          this.swalIncorrecto();
        }
      });
    }
  }

  logout(): void {
    sessionStorage.removeItem('userName');
    sessionStorage.removeItem('password');
    sessionStorage.removeItem('isLogin');
    sessionStorage.removeItem('isAdmin');
    window.location.reload();
  }

}
