package com.helpet.helpetapp.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UsuarioDtoConsulta {
    private Long id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private String avatar;
}
