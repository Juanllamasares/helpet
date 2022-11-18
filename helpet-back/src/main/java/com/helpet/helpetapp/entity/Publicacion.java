package com.helpet.helpetapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "publicaciones")
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String imagen;

    @Column(length = 500)
    private String descripcion;

    @Column(name = "fecha_de_publicacion",length = 50)
    @Temporal(TemporalType.DATE)
    private Date fechaDePublicacion;

    @Column(length = 100)
    private String locacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    @JsonIgnore
    Estado estado;
}
