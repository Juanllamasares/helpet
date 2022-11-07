package com.helpet.helpetback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetback.models.Publicacion;
import com.helpet.helpetback.repository.IPublicacionRepository;

@Service
public class PublicacionServiceImpl implements IPublicacionService{

    @Autowired
    private IPublicacionRepository iPublicacionRepo;

    @Override
    public void crearPublicacion(Publicacion publicacion) {

        iPublicacionRepo.save(publicacion);

    }

    @Override
    public void eliminarPublicacion(Long id) {

        iPublicacionRepo.deleteById(id);

    }

    @Override
    public void modificarPublicacion(Long id, Publicacion publicacion) {

        Publicacion publicacionModificada = iPublicacionRepo.findById(id).get();

        publicacionModificada.setDescripcion(publicacion.getDescripcion());
        publicacionModificada.setFecha(publicacion.getFecha());
        publicacionModificada.setImagen(publicacion.getImagen());
    }

    @Override
    public Publicacion verPublicacionId(Long id) {
        return iPublicacionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Publicacion> verPublicaciones() {
        return iPublicacionRepo.findAll();
    }
    

}
