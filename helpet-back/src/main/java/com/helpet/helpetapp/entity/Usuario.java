package com.helpet.helpetapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore; 
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 2,max = 50)
    private String nombre;

    @NotEmpty(message = "El apellido no debe estar vacio o nulo.")
    @Size(min = 2,max = 50)
    private String apellido;

    @Column(name = "nombre_usuario")
    @NotEmpty(message = "El nombre de usuario no debe estar vacio o nulo.")
    @Size(min = 2, max = 20)
    private String nombreUsuario;

    @NotEmpty(message = "La contraseña no debe estar vacia o nula.")
    @Size(min = 5, max = 50)
    @JsonIgnore
    private String password;

    @Size(max = 200)
    private String avatar;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY,mappedBy = "usuario")
    @JsonIgnore
    private List<Publicacion> publicaciones = new ArrayList<Publicacion>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY,mappedBy = "usuario")
    @JsonIgnore
    List<Comentario> comentarios = new ArrayList<Comentario>();
    
}