package com.helpet.helpetback.services;

import java.util.List;

import com.helpet.helpetback.models.Publicacion;

public interface IPublicacionService {
    
    public void crearPublicacion(Publicacion publicacion);

    public Publicacion verPublicacionId(Long id);

    public List<Publicacion> verPublicaciones();

    public void eliminarPublicacion(Long id);

    public void modificarPublicacion(Long id, Publicacion publicacion);


}
