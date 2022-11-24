package com.helpet.helpetapp.service.comentario;

import java.util.List;

import com.helpet.helpetapp.dto.comentario.ComentarioDtoCreacional;

public interface IComentarioService {
    
    public void crearComentario(ComentarioDtoCreacional comentarioDto);

    public void modificarComentario(Long id,ComentarioDtoCreacional comentarioDto);

    public void eliminarComentario(Long id);

    public List<ComentarioDtoCreacional> obtenerComentarios();

    public ComentarioDtoCreacional obtenerComentarioPorId(Long id);
}
