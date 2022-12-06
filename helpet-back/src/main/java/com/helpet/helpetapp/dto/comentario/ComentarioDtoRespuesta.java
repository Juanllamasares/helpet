package com.helpet.helpetapp.dto.comentario;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ComentarioDtoRespuesta {
    private Long id;
    private String Contenido;
    private Date fecha;
    private Long publicacionId;
    private Long usuarioId;
}
