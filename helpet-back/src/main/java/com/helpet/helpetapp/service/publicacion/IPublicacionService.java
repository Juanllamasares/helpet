package com.helpet.helpetapp.service.publicacion;

import java.util.List;

import com.helpet.helpetapp.dto.publicacion.PublicacionDtoCreacional;
import com.helpet.helpetapp.dto.publicacion.PublicacionDtoRespuesta;

public interface IPublicacionService {

    public void crearPublicacion(PublicacionDtoCreacional publicacionCreacional);
    
    public List<PublicacionDtoRespuesta> obtenerPublicaciones();

    public PublicacionDtoRespuesta obtenerPublicacionPorId(Long id);

    public void eliminarPublicacion(Long id);

    public void modificarPublicacion(Long id, PublicacionDtoCreacional publicacionDtoCreacional);
    
}