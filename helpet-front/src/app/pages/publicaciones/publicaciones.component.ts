import { Component, OnInit } from '@angular/core';
import { Publicacion } from 'src/app/models/publicacion';
import { PublicacionesService } from 'src/app/services/publicaciones.service';

@Component({
  selector: 'app-publicaciones',
  templateUrl: './publicaciones.component.html',
  styleUrls: ['./publicaciones.component.css']
})
export class PublicacionesComponent implements OnInit {

  constructor(private publicacionesService : PublicacionesService) { }

  publicaciones : Publicacion[] = [];

  ngOnInit(): void {

    this.cargarPublicaciones();    

    console.log(this.publicaciones);
    
  }

  cargarPublicaciones():void{
    this.publicacionesService.verPublicaciones().subscribe(data => {
      this.publicaciones = data;
      console.log(data);
    });
  }

}
