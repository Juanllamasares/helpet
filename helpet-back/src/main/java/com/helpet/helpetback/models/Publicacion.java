package com.helpet.helpetback.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publicacion_id;
    
    private String descripcion;
    private String fecha;
    private String imagen;
}
