package com.helpet.helpetback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpet.helpetback.entities.Usuario;
import com.helpet.helpetback.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServ;

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario){

        usuarioServ.crearUsuario(usuario);

        return new ResponseEntity<>("Usuario Creado correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/verUsuarios")
    public ResponseEntity<List<Usuario>> verUsuarios(){

        List<Usuario> usuarios = usuarioServ.verUsuarios();

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/verUsuarioPorId/{id}")
    public ResponseEntity<Usuario> verUsuarioPorId(@PathVariable(name = "id") Long id){

        Usuario usuario = usuarioServ.verUsuarioPorId(id);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/borrarUsuario/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable(name = "id") Long id){

        if(usuarioServ.verUsuarioPorId(id) == null) return new ResponseEntity<>("Usuario con id: " + id + " no encontrado.", HttpStatus.BAD_REQUEST);

        usuarioServ.eliminarUsuario(id);

        return new ResponseEntity<>("Usuario con id: " + id + " Eliminado correctamente.", HttpStatus.OK);
    }
    
}
