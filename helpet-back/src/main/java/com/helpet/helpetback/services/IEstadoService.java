package com.helpet.helpetback.services;

import java.util.List;


import com.helpet.helpetback.entities.Estado;

public interface IEstadoService {
    

    public void crearEstado(Estado estado);

    public List<Estado> obtenerEstados();

    public void eliminarEstado(Long id);

    public Estado obtenerEstadoPorId(Long id);

    public void modificarEstado(Long id, Estado estado);

    public Estado obtenerEstadoPorNombreEstado(String nombreEstado);
}
