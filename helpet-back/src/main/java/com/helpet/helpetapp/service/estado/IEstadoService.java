package com.helpet.helpetapp.service.estado;

import java.util.List;

import com.helpet.helpetapp.dto.estado.EstadoDtoCreacional;
import com.helpet.helpetapp.dto.estado.EstadoDtoRespuesta;

public interface IEstadoService {
    
    public void crearEstado(EstadoDtoCreacional estadoDtoCreacional);
    
    public List<EstadoDtoRespuesta> obtenerEstados();

    public EstadoDtoRespuesta obtenerEstadoPorId(Long id);

    public void eliminarEstado(Long id);
}
