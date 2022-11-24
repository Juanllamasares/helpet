package com.helpet.helpetapp.dto.estado;

import com.helpet.helpetapp.entity.Publicacion;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EstadoDtoRespuesta {
    
    private Long id;
    private String nombreEstado;
    private List<Publicacion> publicaciones;
}
