package com.helpet.helpetapp.service.usuario;

import java.util.List;

import com.helpet.helpetapp.dto.usuario.UsuarioDtoCreacional;
import com.helpet.helpetapp.dto.usuario.UsuarioDtoRespuesta;

public interface IUsuarioService {
    
    public void crearUsuario(UsuarioDtoCreacional usuarioDtoCreacional);
    
    public List<UsuarioDtoRespuesta> obtenerUsuarios();

    public UsuarioDtoRespuesta obtenerUsuarioPorId(Long id);

    public void eliminarUsuario(Long id);
}
