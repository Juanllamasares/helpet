package com.helpet.helpetapp.security.service.userdetail;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.security.entity.Usuario;
import com.helpet.helpetapp.security.entity.UsuarioMain;
import com.helpet.helpetapp.security.service.usuario.UsuarioServiceImpl;

@Service
@Transactional
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioMain.build(usuario);
    }

}
