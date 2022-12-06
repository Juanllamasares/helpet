package com.helpet.helpetapp.security.service.usuario;

import java.util.Optional;


import com.helpet.helpetapp.security.entity.Usuario;

public interface IUsuarioService {
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario);

    public Boolean existsByNombreUsuario(String nombreUsuario);

    public Boolean existsByEmail(String email);

    public void save(Usuario usuario);
}
