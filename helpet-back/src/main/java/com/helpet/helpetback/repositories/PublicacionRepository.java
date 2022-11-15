package com.helpet.helpetback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpet.helpetback.entities.Estado;
import com.helpet.helpetback.entities.Publicacion;
import com.helpet.helpetback.entities.Usuario;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PublicacionRepository extends JpaRepository <Publicacion, Long>{
    
    public List <Publicacion> findByUsuario(Usuario usuario);

    public List<Publicacion> findByEstado(Estado estado);
}
