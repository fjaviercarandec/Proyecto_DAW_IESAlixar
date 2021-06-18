import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/services/client.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  idClient: any;
  nombreClient: string;
  apellidoClient: string;
  clients: any;

  isDeleted: boolean;

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
  }

  getClient(): void {
    this.clientService.getClient(this.idClient, this.nombreClient, this.apellidoClient).subscribe((response) => {
      this.clients = response;
    })
  }

  borradoCorrecto(): void {
    Swal.fire(
      '¡Borrado!',
      'El cliente ha sido borrado.',
      'success'
    );
  }

  borradoIncorrecto(): void {
    Swal.fire(
      '¡Error!',
      'El cliente no ha podido ser borrado',
      'error'
    );
  }

  deleteCliente(event): void {
    let tupla = event.target.parentElement.parentElement;
    let idCliente = tupla.childNodes[0].textContent;
    console.log(idCliente);

    Swal.fire({
      title: '¿Estas seguro?',
      text: "No podráas revertir este cambio",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Confirmar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.clientService.deleteClient(idCliente).subscribe((response) => {
          this.isDeleted = response;
          if(this.isDeleted) {
            this.borradoCorrecto();
          } else {
            this.borradoIncorrecto();
          }
        });
      }
    })

  }


}
