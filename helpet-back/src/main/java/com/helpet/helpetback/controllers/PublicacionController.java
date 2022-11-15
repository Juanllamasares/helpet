package com.helpet.helpetback.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helpet.helpetback.entities.Publicacion;
import com.helpet.helpetback.entities.Usuario;
import com.helpet.helpetback.services.PublicacionServiceImpl;
import com.helpet.helpetback.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionServiceImpl publicacionServ;

    @Autowired
    private UsuarioServiceImpl usuarioServ;


    @PostMapping("/crearPublicacion")
    public ResponseEntity<String> crearPublicacion(@RequestBody Publicacion publicacion) {

        Usuario usuario = usuarioServ.obtenerUsuarioPorId(publicacion.getUsuario().getId());

        usuario.getPublicaciones().add(publicacion);
        
        publicacion.setFecha(new Date());

        publicacionServ.crearPublicacion(publicacion);        

        return new ResponseEntity<>("Publicacion creada correctamente.", HttpStatus.CREATED);
    }

    @GetMapping("/obtenerPublicaciones")
    public ResponseEntity<List<Publicacion>> obtenerPublicaciones() {
        List<Publicacion> publicaciones = publicacionServ.obtenerPublicaciones();

        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }

    @GetMapping("/obtenerPublicacion/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion(@PathVariable(name = "id") Long id) {
        Publicacion publicacion = publicacionServ.obtenerPublicacionPorId(id);

        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PutMapping("/modificarPublicacion")
    public ResponseEntity<String> modificarPublicacion(@RequestParam Long id, @RequestBody Publicacion publicacion) {
        if (publicacionServ.obtenerPublicacionPorId(id) == null)
            return new ResponseEntity<>("El usuario a modificar no existe.", HttpStatus.BAD_REQUEST);
        publicacionServ.modificarPublicacion(id, publicacion);
        return new ResponseEntity<>("Publicacion modificada correctamente.", HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPublicacion/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") Long id) {
        if (publicacionServ.obtenerPublicacionPorId(id) == null)
            return new ResponseEntity<>("Publicacion id: " + id + " no existe.", HttpStatus.BAD_REQUEST);
        publicacionServ.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicacion eliminada correctamente.", HttpStatus.OK);
    }
}
