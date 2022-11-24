package com.helpet.helpetapp.dto.estado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EstadoDtoCreacional {
        
    @NotEmpty(message = "El nombre del estado no debe estar vacio o nulo.")
    @Size(min = 4,max = 50)
    private String nombreEstado;
}
