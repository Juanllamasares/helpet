package com.helpet.helpetback.services;

import java.util.List;

import com.helpet.helpetback.entities.Publicacion;

public interface IPublicacionService {
    
    public void crearPublicacion(Publicacion publicacion);

    public List<Publicacion> obtenerPublicaciones();

    public Publicacion obtenerPublicacionPorId(Long id);

    public void eliminarPublicacion(Long id);

    public void modificarPublicacion(Long id, Publicacion publicacion);
}
