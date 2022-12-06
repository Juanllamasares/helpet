package com.helpet.helpetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpet.helpetapp.dto.comentario.ComentarioDtoCreacional;
import com.helpet.helpetapp.service.comentario.ComentarioServiceImpl;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioServiceImpl comentarioServ;

    @PostMapping("/crear")
    public ResponseEntity<String> crearComentario(@RequestBody ComentarioDtoCreacional comentarioDtoCreacional) {
        comentarioServ.crearComentario(comentarioDtoCreacional);
        return new ResponseEntity<>("Comentario creado correctamente.", HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarComentario(@PathVariable(name = "id") Long id,
            @RequestBody ComentarioDtoCreacional comentarioDtoCreacional) {

        if (comentarioServ.obtenerComentarioPorId(id) == null) return new ResponseEntity<>("El id del comentario no es valido.",HttpStatus.BAD_REQUEST);

        comentarioServ.modificarComentario(id, comentarioDtoCreacional);

        return new ResponseEntity<>("Comentario modificado correctamente.",HttpStatus.OK);
    }
}
