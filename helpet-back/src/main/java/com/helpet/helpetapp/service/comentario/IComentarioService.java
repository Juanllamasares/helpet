package com.helpet.helpetapp.service.comentario;

import java.util.List;

import com.helpet.helpetapp.dto.comentario.ComentarioDtoCreacional;
import com.helpet.helpetapp.dto.comentario.ComentarioDtoRespuesta;

public interface IComentarioService {
    
    public void crearComentario(ComentarioDtoCreacional comentarioDto);

    public void modificarComentario(Long id,ComentarioDtoCreacional comentarioDto);

    public void eliminarComentario(Long id);

    public List<ComentarioDtoRespuesta> obtenerComentarios();

    public ComentarioDtoRespuesta obtenerComentarioPorId(Long id);
}
