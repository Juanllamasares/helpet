package com.helpet.helpetapp.service.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.entity.Estado;
import com.helpet.helpetapp.repository.EstadoRepository;

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
    public Estado obtenerEstadoPorId(Long id) {
        return estadoRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarEstado(Long id) {
        estadoRepo.deleteById(id);
    }
    
}
