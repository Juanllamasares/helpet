package com.helpet.helpetapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetapp.entity.Publicacion;

@Repository
@Transactional
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{
    
}
