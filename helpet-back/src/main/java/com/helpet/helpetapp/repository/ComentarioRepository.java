package com.helpet.helpetapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetapp.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long>{
    
}
