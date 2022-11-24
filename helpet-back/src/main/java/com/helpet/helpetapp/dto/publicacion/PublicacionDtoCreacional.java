package com.helpet.helpetapp.dto.publicacion;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PublicacionDtoCreacional {
    
    @NotEmpty(message = "La url de la imagen no debe estar vacia o nula.")
    @Size(max = 200)
    private String imagen;
    @NotEmpty(message = "La descripcion no debe estar vacia o nula.")
    @Size(max = 1000)
    private String descripcion;
    @NotNull
    private Date fechaDePublicacion;
    @NotEmpty(message = "La locacion no debe estar vacia o nula.")
    @Size(max = 100)
    private String locacion;
    @NotEmpty(message = "El id del usuario no debe estar vacio o nulo.")
    private Long usuarioId;
    @NotEmpty(message = "El id de el estado no debe estar vacio o nulo.")
    private Long estadoId;
}
