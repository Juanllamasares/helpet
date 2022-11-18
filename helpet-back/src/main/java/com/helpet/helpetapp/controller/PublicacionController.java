package com.helpet.helpetapp.controller;

import java.util.Date;
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

import com.helpet.helpetapp.entity.Estado;
import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.entity.Usuario;
import com.helpet.helpetapp.service.estado.EstadoServiceImpl;
import com.helpet.helpetapp.service.publicacion.PublicacionServiceImpl;
import com.helpet.helpetapp.service.usuario.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    
    @Autowired
    private PublicacionServiceImpl publicacionServ;

    @Autowired
    private UsuarioServiceImpl usuarioserv;

    @Autowired
    private EstadoServiceImpl estadoServ;

    @PostMapping("/crear")
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion){

        return publicacion;


        //if (publicacion.getUsuario().getId() == null) return new ResponseEntity<>("El usuario No existe.",HttpStatus.BAD_REQUEST);
        //if (publicacion.getEstado().getId() == null) return new ResponseEntity<>("El estado No existe.",HttpStatus.BAD_REQUEST);
//
//
        //Usuario usuario = usuarioserv.obtenerUsuarioPorId(publicacion.getUsuario().getId());
        //
        //Estado estado = estadoServ.obtenerEstadoPorId(publicacion.getEstado().getId());
//
        //usuario.getPublicaciones().add(publicacion);
        //estado.getPublicaciones().add(publicacion);
//
        //publicacion.setFechaDePublicacion(new Date());
//
        //publicacionServ.crearPublicacion(publicacion);
        //return new ResponseEntity<>("Publicacion creada correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/obtenerPublicaciones")
    public ResponseEntity<List<Publicacion>> obtenerPublicaciones(){
        List<Publicacion> publicaciones = publicacionServ.obtenerPublicaciones();
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") Long id){
        if(publicacionServ.obtenerPublicacionPorId(id) == null) return new ResponseEntity<>("Publicacion no encontrada.",HttpStatus.BAD_REQUEST);
        publicacionServ.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicacion eliminada correctamente.",HttpStatus.OK);
    }
}
