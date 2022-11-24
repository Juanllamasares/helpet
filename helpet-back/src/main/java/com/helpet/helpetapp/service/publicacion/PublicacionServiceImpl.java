package com.helpet.helpetapp.service.publicacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.publicacion.PublicacionDtoCreacional;
import com.helpet.helpetapp.dto.publicacion.PublicacionDtoRespuesta;
import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.entity.Usuario;
import com.helpet.helpetapp.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements IPublicacionService{

    @Autowired
    private PublicacionRepository publicacionServ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearPublicacion(PublicacionDtoCreacional publicacionCreacional) {
        Publicacion publicacion = modelMapper.map(publicacionCreacional, Publicacion.class);
        publicacionServ.save(publicacion);
    }

    @Override
    public List<PublicacionDtoRespuesta> obtenerPublicaciones() {
        return null;
    }

    @Override
    public PublicacionDtoRespuesta obtenerPublicacionPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarPublicacion(Long id) {
        
    }

    @Override
    public void modificarPublicacion(Long id, PublicacionDtoCreacional publicacionDtoCreacional) {
        
    }

    
    
}
