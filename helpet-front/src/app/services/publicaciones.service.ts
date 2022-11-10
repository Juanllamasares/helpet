import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Publicacion } from '../models/publicacion';

@Injectable({
  providedIn: 'root',
})
export class PublicacionesService {

  url:string = environment.baseUrl;


  constructor(private httpClient: HttpClient) {}


  public verPublicaciones():Observable<Publicacion[]>{
    return this.httpClient.get<Publicacion[]>(
      this.url + '/publicaciones/verPublicaciones'
    );
  }
}
