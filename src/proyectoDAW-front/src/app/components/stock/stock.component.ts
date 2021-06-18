import { Component, OnInit } from '@angular/core';
import { StockService } from 'src/app/services/stock.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  nombre: string;
  cantidad: number;
  talla: string;
  color: string;
  descripcion: string;
  productos: any;
  
  idSearch: any;
  nameSearch: string;
  colorSearch: string;
  productosSearch: any;

  productoUpdated: any;

  isDeleted: any;

  constructor(private stockService: StockService) { 
  }

  ngOnInit(): void {
  }

  addProduct(): void {
    this.stockService.addProduct(this.nombre, this.cantidad, this.talla, this.color, this.descripcion).subscribe((response) => {
      this.productos = response;
    });

    let timerInterval: any;
    Swal.fire({
      title: '¡Añadiendo tu producto!',
      html: '',
      timer: 1000,
      timerProgressBar: true,
      didOpen: () => {
        Swal.showLoading()
      },
      willClose: () => {
        clearInterval(timerInterval)
      }
    }).then((result) => {
      /* Read more about handling dismissals below */
      if (result.dismiss === Swal.DismissReason.timer) {
        console.log('I was closed by the timer')
        if(this.productos) {
          Swal.fire(
            '¡Producto añadido!',
            '',
            'success'
          )
        } else {
          Swal.fire(
            '¡Error!',
            'No se ha podido añadir tu producto.',
            'error'
          )
        }
      }
    });
    this.productos = false;
  }

  searchProducts(): void {
    this.stockService.searchProducts(this.idSearch, this.nameSearch, this.colorSearch).subscribe((response) => {
      this.productosSearch = response;
    });
  }

  productoActualizadoCorrecto(): void {
    Swal.fire(
      '¡Actualizado!',
      'El producto ha sido actualizado.',
      'success'
    );
  }

  productoActualizadoIncorrecto(): void {
    Swal.fire(
      '¡Error!',
      'El producto no podido ha ser actualizado.',
      'error'
    );
  }

  updateProduct(event): void {
    let tupla = event.target.parentElement.parentElement;
    let idProducto = tupla.childNodes[0].textContent;
    let nombreProducto = tupla.childNodes[1].textContent;
    let cantidadProducto = tupla.childNodes[2].textContent;
    let tamañoProducto = tupla.childNodes[3].textContent;
    let colorProducto = tupla.childNodes[4].textContent;

    const res = Swal.fire({
      title: 'Actualizar producto',
      html: 
        '<label>Nombre:</label>' +
        '<input id="swal-input1" class="swal2-input"></div><br>' +
        '<label>Cantidad:</label>' +
        '<input id="swal-input2" class="swal2-input"><br>' +
        '<label style="padding-top: 10px;">Talla:</label>' +
        '<select id="swal-input3"><option value="XS">XS</option><option value="S">S</option><option value="M">M</option><option value="L">L</option><option value="XL">XL</option><option value="" selected></option></select><br>' +
        '<label style="padding-top: 10px;">Color:</label>' +
        '<select id="swal-input4"><option value="Azul">Azul</option><option value="Verde">Verde</option><option value="Rojo">Rojo</option><option value="Blanco">Blanco</option><option value="Negro">Negro</option><option value="" selected></option></select>',
      focusConfirm: false,
      preConfirm: () => {
        let nombreProductoNew;
        let cantidadProductoNew;
        let tallaProductoNew;
        let colorProductoNew;
        if((document.getElementById("swal-input1") as HTMLInputElement).value == "") {
          nombreProductoNew = null;
          console.log(nombreProductoNew);
        } else {
          nombreProductoNew = (document.getElementById("swal-input1") as HTMLInputElement).value;
        }

        if((document.getElementById("swal-input2") as HTMLInputElement).value == "") {
          cantidadProductoNew = cantidadProducto;
        } else {
          cantidadProductoNew = (document.getElementById("swal-input2") as HTMLInputElement).value;
        }

        if((document.getElementById("swal-input3") as HTMLInputElement).value == "") {
          tallaProductoNew = null;
        } else {
          tallaProductoNew = (document.getElementById("swal-input3") as HTMLInputElement).value;
        }

        if((document.getElementById("swal-input4") as HTMLInputElement).value == "") {
          colorProductoNew = null;
        } else {
          colorProductoNew = (document.getElementById("swal-input4") as HTMLInputElement).value;
        }

        this.stockService.updateProduct(idProducto, nombreProductoNew, cantidadProductoNew, tallaProductoNew, colorProductoNew).subscribe((response) => {
          this.productoUpdated = response;
          if(this.productoUpdated == true) {
            this.productoActualizadoCorrecto();
          } else {
            this.productoActualizadoIncorrecto();
          }
        })
      }
    });

  }

  borradoCorrecto(): void {
    Swal.fire(
      '¡Borrado!',
      'El producto ha sido borrado.',
      'success'
    );
  }

  borradoIncorrecto(): void {
    Swal.fire(
      '¡Error!',
      'El producto no ha podido ser borrado',
      'error'
    );
  }

  deleteProducto(event): void {
    let tupla = event.target.parentElement.parentElement;
    let idproducto = tupla.childNodes[0].textContent;
    console.log(idproducto);

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
        this.stockService.deleteProduct(idproducto).subscribe((response) => {
          this.isDeleted = response;
          console.log(this.isDeleted);
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
