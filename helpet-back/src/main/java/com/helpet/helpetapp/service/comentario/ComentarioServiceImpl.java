package com.helpet.helpetapp.service.comentario;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.comentario.ComentarioDtoCreacional;
import com.helpet.helpetapp.entity.Comentario;
import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.entity.Usuario;
import com.helpet.helpetapp.repository.ComentarioRepository;
import com.helpet.helpetapp.repository.PublicacionRepository;
import com.helpet.helpetapp.repository.UsuarioRepository;

@Service
public class ComentarioServiceImpl implements IComentarioService{

    @Autowired
    private ComentarioRepository comentarioRepo;
    @Autowired 
    private UsuarioRepository usuarioRepo;
    @Autowired
    private PublicacionRepository publicacionRepo;

    @Override
    public void crearComentario(ComentarioDtoCreacional comentarioDto) {
        Comentario comentario = new Comentario();
        Usuario usuario = usuarioRepo.findById(comentarioDto.getUsuarioId()).get();
        Publicacion publicacion = publicacionRepo.findById(comentarioDto.getPublicacionId()).get();

        comentario.setFecha(new Date());
        comentario.setContenido(comentarioDto.getContenido());
        comentario.setPublicacion(publicacion);
        comentario.setUsuario(usuario);

        comentarioRepo.save(comentario);
    }

    @Override
    public void modificarComentario(Long id, ComentarioDtoCreacional comentarioDto) {
        
    }

    @Override
    public void eliminarComentario(Long id) {
        
    }

    @Override
    public List<ComentarioDtoCreacional> obtenerComentarios() {
        return null;
    }

    @Override
    public ComentarioDtoCreacional obtenerComentarioPorId(Long id) {
        return null;
    }
    
}
