package com.helpet.helpetapp.dto.publicacion;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PublicacionDtoConsulta {
    
    private Long id;
    private String imagen;
    private String descripcion;
    private Date fechaDePublicacion;
    private String locacion;
}
