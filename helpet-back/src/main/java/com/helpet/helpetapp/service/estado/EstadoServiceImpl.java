package com.helpet.helpetapp.service.estado;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.estado.EstadoDtoCreacional;
import com.helpet.helpetapp.dto.estado.EstadoDtoRespuesta;
import com.helpet.helpetapp.entity.Estado;
import com.helpet.helpetapp.repository.EstadoRepository;

@Service
@Transactional
public class EstadoServiceImpl implements IEstadoService{

    @Autowired
    private EstadoRepository estadoRepo;
    @Autowired
    private ModelMapper modelMapper; 
    

    @Override
    public void eliminarEstado(Long id) {
        estadoRepo.deleteById(id);
    }



    @Override
    public void crearEstado(EstadoDtoCreacional estadoDtoCreacional) {
        Estado estado = modelMapper.map(estadoDtoCreacional, Estado.class);
        estadoRepo.save(estado);
    }



    @Override
    public List<EstadoDtoRespuesta> obtenerEstados() {
        List<Estado> entities = estadoRepo.findAll();
        List<EstadoDtoRespuesta> dtos = new LinkedList<>();

        for(Estado estado : entities){
            dtos.add(0, modelMapper.map(estado, EstadoDtoRespuesta.class));
        }
        return dtos;
    }



    @Override
    public EstadoDtoRespuesta obtenerEstadoPorId(Long id) {
        Estado estado = estadoRepo.findById(id).get();
        EstadoDtoRespuesta dto = modelMapper.map(estado, EstadoDtoRespuesta.class);
        return dto;
    }
    
}
