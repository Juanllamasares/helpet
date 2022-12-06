package com.helpet.helpetapp.security.service.usuario;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.security.entity.Usuario;
import com.helpet.helpetapp.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);        
    }
    
    
}
