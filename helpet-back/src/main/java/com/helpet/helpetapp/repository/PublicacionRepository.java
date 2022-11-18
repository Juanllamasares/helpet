package com.helpet.helpetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpet.helpetapp.entity.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{
    
}
