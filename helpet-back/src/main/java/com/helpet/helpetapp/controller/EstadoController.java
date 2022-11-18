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

import com.helpet.helpetapp.entity.Estado;
import com.helpet.helpetapp.service.estado.EstadoServiceImpl;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    
    @Autowired
    private EstadoServiceImpl estadoServ;

    @PostMapping("/crear")
    public ResponseEntity<String> crearEstado(@RequestBody Estado estado){
        estadoServ.crearEstado(estado);
        return new ResponseEntity<>("Estado creado correctamente.",HttpStatus.CREATED);
    }

    @GetMapping("/obtenerEstados")
    public ResponseEntity<List<Estado>> obtenerEstados(){
        List<Estado> estados = estadoServ.obtenerEstados();
        return new ResponseEntity<>(estados,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEstado(@PathVariable(name = "id") Long id){
        if(estadoServ.obtenerEstadoPorId(id) == null) return new ResponseEntity<>("Estado no encontrado.",HttpStatus.BAD_REQUEST);
        estadoServ.eliminarEstado(id);
        return new ResponseEntity<>("Estado eliminado correctamente.",HttpStatus.OK);
    }
}
