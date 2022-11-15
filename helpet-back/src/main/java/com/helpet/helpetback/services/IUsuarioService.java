package com.helpet.helpetback.services;

import java.util.List;

import com.helpet.helpetback.entities.Usuario;

public interface IUsuarioService {
    
    public void crearUsuario(Usuario usuario);

    public void eliminarUsuario(Long id);

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerUsuarioPorId(Long id);
}
