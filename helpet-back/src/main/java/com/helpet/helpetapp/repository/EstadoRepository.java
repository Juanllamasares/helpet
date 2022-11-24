package com.helpet.helpetapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpet.helpetapp.entity.Estado;

@Repository
@Transactional
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}
