package com.helpet.helpetapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpet.helpetapp.dto.publicacion.PublicacionDtoCreacional;
import com.helpet.helpetapp.dto.publicacion.PublicacionDtoRespuesta;
import com.helpet.helpetapp.service.publicacion.PublicacionServiceImpl;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    
    @Autowired
    private PublicacionServiceImpl publicacionServ;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPublicacion(@RequestBody PublicacionDtoCreacional publicacionDtoCreacional){
        publicacionDtoCreacional.setFechaDePublicacion(new Date());

        publicacionServ.crearPublicacion(publicacionDtoCreacional);

        return new ResponseEntity<>("Publicacion creada correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/obtenerPublicaciones")
    public ResponseEntity<List<PublicacionDtoRespuesta>> obtenerPublicaciones(){
        List<PublicacionDtoRespuesta> publicaciones = publicacionServ.obtenerPublicaciones();
        return new ResponseEntity<>(publicaciones,HttpStatus.OK);
    }
    
}
