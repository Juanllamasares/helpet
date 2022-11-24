package com.helpet.helpetapp.controller;

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

import com.helpet.helpetapp.dto.usuario.UsuarioDtoCreacional;
import com.helpet.helpetapp.dto.usuario.UsuarioDtoRespuesta;
import com.helpet.helpetapp.service.usuario.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServ;

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDtoCreacional usuarioDtoCreacional){
        usuarioServ.crearUsuario(usuarioDtoCreacional);
        return new ResponseEntity<>("Usuario creado correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/obtenerUsuarios")
    public ResponseEntity<List<UsuarioDtoRespuesta>> obtenerUsuarios(){
        List<UsuarioDtoRespuesta> usuarios = usuarioServ.obtenerUsuarios();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

    @GetMapping("/obtenerUsuario/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable(name = "id") Long id){
        if(usuarioServ.obtenerUsuarioPorId(id)==null) return new ResponseEntity<>("Usuario no encontrado.",HttpStatus.BAD_REQUEST);
        UsuarioDtoRespuesta usuarioDto = usuarioServ.obtenerUsuarioPorId(id);
        return new ResponseEntity<>(usuarioDto,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id") Long id){
        if(usuarioServ.obtenerUsuarioPorId(id) == null) return new ResponseEntity<>("Usuario no encontrado.",HttpStatus.BAD_REQUEST);
        usuarioServ.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado  correctamente.",HttpStatus.OK);
    }
}
