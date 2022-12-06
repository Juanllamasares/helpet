package com.helpet.helpetapp.security.service.rol;

import java.util.Optional;

import com.helpet.helpetapp.security.entity.Rol;
import com.helpet.helpetapp.security.enums.RolNombre;

public interface IRolService {
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre);

    public void saveRol(Rol rol);
}
