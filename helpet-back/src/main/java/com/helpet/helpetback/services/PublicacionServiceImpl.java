package com.helpet.helpetback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetback.entities.Publicacion;
import com.helpet.helpetback.repositories.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements IPublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepo;

    @Override
    public void crearPublicacion(Publicacion publicacion) {
        publicacionRepo.save(publicacion);
    }

    @Override
    public List<Publicacion> obtenerPublicaciones() {
        return publicacionRepo.findAll();
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        publicacionRepo.deleteById(id);
    }

    @Override
    public void modificarPublicacion(Long id, Publicacion publicacion) {
        Publicacion publicacionModificada = publicacionRepo.findById(id).get();
        
        publicacionModificada.setDescripcion(publicacion.getDescripcion());
        publicacionModificada.setImagen(publicacion.getImagen());
        publicacionModificada.setEstado(publicacion.getEstado());
        publicacionModificada.setUsuario(publicacion.getUsuario());

        publicacionRepo.save(publicacionModificada);
    }
    
}
