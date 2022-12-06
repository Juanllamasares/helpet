package com.helpet.helpetapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetapp.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}
