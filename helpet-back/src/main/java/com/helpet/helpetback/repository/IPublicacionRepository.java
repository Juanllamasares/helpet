package com.helpet.helpetback.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetback.models.Publicacion;

@Repository
@Transactional
public interface IPublicacionRepository extends JpaRepository<Publicacion, Long>{
    
}
