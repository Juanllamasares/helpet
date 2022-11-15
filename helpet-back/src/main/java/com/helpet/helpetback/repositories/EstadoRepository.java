package com.helpet.helpetback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpet.helpetback.entities.Estado;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EstadoRepository extends JpaRepository <Estado, Long>{
    public Estado findByNombreEstado(String nombreEstado);
}
