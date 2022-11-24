package com.helpet.helpetapp.dto.comentario;

import java.util.Date;

import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ComentarioDtoRespuesta {
    private Long id;
    private String Contenido;
    private Date fecha;
    private Publicacion publicacion;
    private Usuario usuario;
}
