package com.helpet.helpetback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpet.helpetback.models.Publicacion;
import com.helpet.helpetback.services.PublicacionServiceImpl;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionServiceImpl publicacionServ;
    
    @PostMapping("/crearPublicacion")
    public ResponseEntity<String> crearPublicacion(@RequestBody Publicacion publicacion){
        
        publicacionServ.crearPublicacion(publicacion);

        return new ResponseEntity<>("Publicacion creada correctamente.", HttpStatus.CREATED);

    }

    @GetMapping("/verPublicaciones")
    @ResponseBody
    public ResponseEntity<List<Publicacion>> verPublicaciones(){

        List<Publicacion> publicaciones = publicacionServ.verPublicaciones();

        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
}
