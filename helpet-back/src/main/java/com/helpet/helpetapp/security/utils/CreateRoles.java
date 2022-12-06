/* package com.helpet.helpetapp.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.helpet.helpetapp.security.entity.Rol;
import com.helpet.helpetapp.security.enums.RolNombre;
import com.helpet.helpetapp.security.service.rol.RolServiceImpl;

@Component
public class CreateRoles implements CommandLineRunner{

    @Autowired
    RolServiceImpl rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(1, RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(2,RolNombre.ROLE_USER);
        rolService.saveRol(rolAdmin);
        rolService.saveRol(rolUser);
    }
    
} 
 */