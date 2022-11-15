package com.helpet.helpetback.controllers;

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

import com.helpet.helpetback.entities.Estado;
import com.helpet.helpetback.services.EstadoServiceImpl;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    
    @Autowired
    private EstadoServiceImpl estadoServ;

    @PostMapping("/crearEstado")
    public ResponseEntity<String> crearEstado(@RequestBody Estado estado){
        estadoServ.crearEstado(estado);
        return new ResponseEntity<>("Estado creado correctamente.", HttpStatus.CREATED);
    }

    @GetMapping("/obtenerEstados")
    public ResponseEntity<List<Estado>> obtenerEstados(){
        List<Estado> estados = estadoServ.obtenerEstados();

        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/obtenerEstado/{id}")
    public ResponseEntity<Estado> obtenerEstado(@PathVariable(name = "id") Long id){
        Estado estado = estadoServ.obtenerEstadoPorId(id);

        return new ResponseEntity<>(estado, HttpStatus.OK);
    }

    @PutMapping("/modificarEstado")
    public ResponseEntity<String> modificarEstado(@RequestParam Long id, @RequestBody Estado estado){
        if(estadoServ.obtenerEstadoPorId(id)==null) return new ResponseEntity<>("Ese estado no existe.", HttpStatus.BAD_REQUEST);

        estadoServ.modificarEstado(id, estado);
        return new ResponseEntity<>("Estado modificado correctamente.", HttpStatus.OK);
    }

    @DeleteMapping("/eliminarEstado/{id}")
    public ResponseEntity<String> eliminarEstado(@PathVariable(name = "id") Long id){

        if(estadoServ.obtenerEstadoPorId(id)==null) return new ResponseEntity<>("Ese estado no existe.", HttpStatus.BAD_REQUEST);

        estadoServ.eliminarEstado(id);

        return new ResponseEntity<>("Estado eliminado correctamente.",HttpStatus.OK);
    }

}
