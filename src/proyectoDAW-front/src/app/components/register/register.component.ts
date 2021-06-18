import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  nombre: any;
  apellido: string;
  telefono: string;
  email: string;
  pass: string;
  user: any;

  form = new FormGroup({
    nombre: new FormControl('nombre', Validators.required),
    email: new FormControl('email', [Validators.required, Validators.email]),
    password: new FormControl('password', Validators.required)
  });

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  signIn(): void {
    this.userService.signIn(this.nombre, this.apellido, this.telefono, this.email, this.pass).subscribe((response) => {
      this.user = response;
    });

    if(this.user!=null) {
      Swal.fire('¡Registro finalizado!', '', 'success');
    } else {
      Swal.fire('¡Error!', 'Usuario ya registrado.', 'error')
    }
  }

}
