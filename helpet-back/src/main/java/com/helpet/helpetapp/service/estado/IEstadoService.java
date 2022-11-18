package com.helpet.helpetapp.service.estado;

import java.util.List;

import com.helpet.helpetapp.entity.Estado;

public interface IEstadoService {
    
    public void crearEstado(Estado estado);
    
    public List<Estado> obtenerEstados();

    public Estado obtenerEstadoPorId(Long id);

    public void eliminarEstado(Long id);
}
