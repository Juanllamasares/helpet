package com.helpet.helpetapp.service.usuario;

import java.util.List;

import com.helpet.helpetapp.entity.Usuario;

public interface IUsuarioService {
    
    public void crearUsuario(Usuario usuario);
    
    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerUsuarioPorId(Long id);

    public void eliminarUsuario(Long id);
}
