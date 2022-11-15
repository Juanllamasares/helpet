import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Publicacion } from 'src/app/models/publicacion';
import { PublicacionesService } from 'src/app/services/publicaciones.service';

@Component({
  selector: 'app-publicar',
  templateUrl: './publicar.component.html',
  styleUrls: ['./publicar.component.css'],
})
export class PublicarComponent implements OnInit {
  constructor(
    private publicacionesService: PublicacionesService,
    private fb: FormBuilder
  ) {}

  fecha = new Date();

  formulario: FormGroup = this.fb.group({
    descripcion: [],
    fecha: [this.fecha.toISOString().slice(0,10)],
    imagen: [],
  });

  ngOnInit(): void {}

  crear():void{
    const publicacion = this.formulario.value;

    console.log(publicacion);
    
    this.publicacionesService.crearPublicacion(publicacion).subscribe(()=>{alert("todo salio bien")},error=>{console.log(error);
    })
    
  }
}
