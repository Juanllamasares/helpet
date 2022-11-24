package com.helpet.helpetapp.dto.comentario;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ComentarioDtoCreacional {
    
    @NotEmpty(message = "EL contenido no puede estar vacio o nulo.")
    @Size(min = 1,max = 500)
    private String contenido;
    private Date fecha;
    @NotEmpty(message = "El id de la publicacion no debe ser nulo.")
    private Long publicacionId;
    @NotEmpty(message = "El id del usuario no debe ser nulo.")
    private Long usuarioId;
}
