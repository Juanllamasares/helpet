package com.helpet.helpetapp.service.publicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements IPublicacionService{

    @Autowired
    private PublicacionRepository publicacionServ;

    @Override
    public void crearPublicacion(Publicacion publicacion) {
        publicacionServ.save(publicacion);        
    }

    @Override
    public List<Publicacion> obtenerPublicaciones() {
        return publicacionServ.findAll();
    }

    @Override
    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionServ.findById(id).orElse(null);
    }

    @Override
    public void eliminarPublicacion(Long id) {
        publicacionServ.deleteById(id);        
    }

   
    
}
