package com.helpet.helpetback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpet.helpetback.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    
}
