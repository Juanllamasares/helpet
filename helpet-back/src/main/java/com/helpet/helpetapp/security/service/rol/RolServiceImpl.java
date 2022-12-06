package com.helpet.helpetapp.security.service.rol;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.security.entity.Rol;
import com.helpet.helpetapp.security.enums.RolNombre;
import com.helpet.helpetapp.security.repository.RolRepository;

@Service
@Transactional
public class RolServiceImpl implements IRolService{

    @Autowired
    private RolRepository rolRepo;

    @Override
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepo.findByRolNombre(rolNombre);
    }

    @Override
    public void saveRol(Rol rol) {
        rolRepo.save(rol);
    }
    
}
