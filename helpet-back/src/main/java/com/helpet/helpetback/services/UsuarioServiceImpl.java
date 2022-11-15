package com.helpet.helpetback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetback.entities.Usuario;
import com.helpet.helpetback.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }
    
}
