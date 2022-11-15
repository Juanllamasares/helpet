package com.helpet.helpetback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetback.entities.Estado;
import com.helpet.helpetback.repositories.EstadoRepository;

@Service
public class EstadoServiceImpl implements IEstadoService{

    @Autowired
    private EstadoRepository estadoRepo;

    @Override
    public void crearEstado(Estado estado) {
        estadoRepo.save(estado);
    }

    @Override
    public List<Estado> obtenerEstados() {
        return estadoRepo.findAll();
    }

    @Override
    public void eliminarEstado(Long id) {
        estadoRepo.deleteById(id);
    }

    @Override
    public Estado obtenerEstadoPorId(Long id) {
        return estadoRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarEstado(Long id, Estado estado) {
        
        Estado estadoModificado = estadoRepo.findById(id).get();

        estadoModificado.setNombreEstado(estado.getNombreEstado());

        estadoRepo.save(estadoModificado);
    }

    @Override
    public Estado obtenerEstadoPorNombreEstado(String nombreEstado) {
        return estadoRepo.findByNombreEstado(nombreEstado);
    }
    
}
