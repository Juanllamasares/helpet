package com.helpet.helpetapp.security.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetapp.security.entity.Rol;
import com.helpet.helpetapp.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    public Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
