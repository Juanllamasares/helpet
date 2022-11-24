package com.helpet.helpetapp.dto.usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UsuarioDtoCreacional {

    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 2,max = 50)
    private String nombre;
    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 2,max = 50)
    private String apellido;
    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 2,max = 20)
    private String nombreUsuario;
    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 5,max = 50)
    private String password;
    @NotEmpty(message = "El nombre no debe estar vacio o nulo.")
    @Size(min = 2,max = 200)
    private String avatar;
    
}
