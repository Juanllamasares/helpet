package com.helpet.helpetapp.service.comentario;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.comentario.ComentarioDtoCreacional;
import com.helpet.helpetapp.dto.comentario.ComentarioDtoRespuesta;
import com.helpet.helpetapp.entity.Comentario;
import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.repository.ComentarioRepository;
import com.helpet.helpetapp.repository.PublicacionRepository;
import com.helpet.helpetapp.security.entity.Usuario;
import com.helpet.helpetapp.security.repository.UsuarioRepository;

@Service
@Transactional
public class ComentarioServiceImpl implements IComentarioService{

    @Autowired
    private ComentarioRepository comentarioRepo;
    @Autowired 
    private UsuarioRepository usuarioRepo;
    @Autowired
    private PublicacionRepository publicacionRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearComentario(ComentarioDtoCreacional comentarioDtoCreacional) {
        Comentario comentario = new Comentario();
        Usuario usuario = usuarioRepo.findById(comentarioDtoCreacional.getUsuarioId()).get();
        Publicacion publicacion = publicacionRepo.findById(comentarioDtoCreacional.getPublicacionId()).get();

        comentario.setFecha(new Date());
        comentario.setContenido(comentarioDtoCreacional.getContenido());
        comentario.setPublicacion(publicacion);
        comentario.setUsuario(usuario);

        comentarioRepo.save(comentario);
    }

    @Override
    public void modificarComentario(Long id, ComentarioDtoCreacional comentarioDtoCreacional) {
        Comentario comentario = comentarioRepo.findById(id).get();
        comentario.setContenido(comentarioDtoCreacional.getContenido());
        
        comentarioRepo.save(comentario);
        
    }

    @Override
    public void eliminarComentario(Long id) {
        comentarioRepo.deleteById(id);        
    }

    @Override
    public List<ComentarioDtoRespuesta> obtenerComentarios() {
        List<Comentario> entities = comentarioRepo.findAll();
        List<ComentarioDtoRespuesta> dtos = new LinkedList<>();

        for(Comentario comentario : entities){
            dtos.add(0, modelMapper.map(comentario,ComentarioDtoRespuesta.class));
        }
        return dtos;
    }

    @Override
    public ComentarioDtoRespuesta obtenerComentarioPorId(Long id) {
        Comentario comentario = comentarioRepo.findById(id).get();
        ComentarioDtoRespuesta dto = new ComentarioDtoRespuesta();

        dto.setId(comentario.getId());
        dto.setContenido(comentario.getContenido());
        dto.setFecha(comentario.getFecha());
        dto.setPublicacionId(comentario.getPublicacion().getId());
        dto.setUsuarioId(comentario.getUsuario().getId());

        return dto;
    }

   
    
}
