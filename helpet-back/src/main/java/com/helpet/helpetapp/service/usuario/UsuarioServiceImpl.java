package com.helpet.helpetapp.service.usuario;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.usuario.UsuarioDtoCreacional;
import com.helpet.helpetapp.dto.usuario.UsuarioDtoRespuesta;
import com.helpet.helpetapp.entity.Usuario;
import com.helpet.helpetapp.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearUsuario(UsuarioDtoCreacional usuarioDtoCreacional) {
        Usuario usuario = modelMapper.map(usuarioDtoCreacional, Usuario.class);
        //usuario.setNombre(usuarioDtoCreacional.getNombre());
        //usuario.setApellido(usuarioDtoCreacional.getApellido());
        //usuario.setNombreUsuario(usuarioDtoCreacional.getNombreUsuario());
        //usuario.setPassword(usuarioDtoCreacional.getPassword());
        //usuario.setAvatar(usuarioDtoCreacional.getAvatar());
        usuarioRepo.save(usuario);
    }

    @Override
    public List<UsuarioDtoRespuesta> obtenerUsuarios() {

        List<Usuario> entities = usuarioRepo.findAll();
        List<UsuarioDtoRespuesta> dtos = new ArrayList<>();

        for(Usuario usuario : entities){
            dtos.add(modelMapper.map(usuario, UsuarioDtoRespuesta.class));
        }

        return dtos;
    }

    @Override
    public UsuarioDtoRespuesta obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepo.findById(id).get();
        UsuarioDtoRespuesta usuarioDtoRespuesta = modelMapper.map(usuario, UsuarioDtoRespuesta.class);
        return usuarioDtoRespuesta;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    
    
}
