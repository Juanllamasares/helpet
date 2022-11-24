package com.helpet.helpetapp.dto.usuario;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpet.helpetapp.entity.Comentario;
import com.helpet.helpetapp.entity.Publicacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UsuarioDtoRespuesta {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    @JsonIgnore
    private String password;
    private String avatar;
    private List <Publicacion> publicaciones;
    private List <Comentario> comentarios;
}
