package com.helpet.helpetapp.service.publicacion;

import java.util.List;

import com.helpet.helpetapp.entity.Publicacion;

public interface IPublicacionService {

    public void crearPublicacion(Publicacion publicacion);
    
    public List<Publicacion> obtenerPublicaciones();

    public Publicacion obtenerPublicacionPorId(Long id);

    public void eliminarPublicacion(Long id);
    
}