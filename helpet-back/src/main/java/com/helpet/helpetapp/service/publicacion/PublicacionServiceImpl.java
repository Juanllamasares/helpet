package com.helpet.helpetapp.service.publicacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpet.helpetapp.dto.publicacion.PublicacionDtoCreacional;
import com.helpet.helpetapp.dto.publicacion.PublicacionDtoRespuesta;
import com.helpet.helpetapp.entity.Estado;
import com.helpet.helpetapp.entity.Publicacion;
import com.helpet.helpetapp.repository.EstadoRepository;
import com.helpet.helpetapp.repository.PublicacionRepository;
import com.helpet.helpetapp.security.entity.Usuario;
import com.helpet.helpetapp.security.repository.UsuarioRepository;

@Service
@Transactional
public class PublicacionServiceImpl implements IPublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepo;
    @Autowired  
    private UsuarioRepository usuarioRepo;
    @Autowired
    private EstadoRepository estadoRepo;

    @Override
    public void crearPublicacion(PublicacionDtoCreacional publicacionCreacional) {

        Usuario usuario = usuarioRepo.findById(publicacionCreacional.getUsuarioId()).get();
        Estado estado = estadoRepo.findById(publicacionCreacional.getEstadoId()).get();
        Publicacion publicacion = new Publicacion();

        publicacion.setDescripcion(publicacionCreacional.getDescripcion());
        publicacion.setFechaDePublicacion(publicacionCreacional.getFechaDePublicacion());
        publicacion.setImagen(publicacionCreacional.getImagen());
        publicacion.setLocacion(publicacionCreacional.getLocacion());
        publicacion.setUsuario(usuario);
        publicacion.setEstado(estado);

        publicacionRepo.save(publicacion);
    }

    @Override
    public List<PublicacionDtoRespuesta> obtenerPublicaciones() {
        List<Publicacion> entities = publicacionRepo.findAll();
        List<PublicacionDtoRespuesta> publicacionDtoRespuestas = new ArrayList<>();

        for(Publicacion publicacion : entities){

            PublicacionDtoRespuesta publicacionDtoRespuesta = new PublicacionDtoRespuesta();
            publicacionDtoRespuesta.setId(publicacion.getId());
            publicacionDtoRespuesta.setDescripcion(publicacion.getDescripcion());
            publicacionDtoRespuesta.setImagen(publicacion.getImagen());
            publicacionDtoRespuesta.setFechaDePublicacion(publicacion.getFechaDePublicacion());
            publicacionDtoRespuesta.setLocacion(publicacion.getLocacion());
            publicacionDtoRespuesta.setEstadoId(publicacion.getEstado().getId());
            publicacionDtoRespuesta.setUsuarioId(publicacion.getUsuario().getId());
            publicacionDtoRespuesta.setComentarios(publicacion.getComentarios());

            publicacionDtoRespuestas.add(publicacionDtoRespuesta);
        }
        return publicacionDtoRespuestas;
    }

    @Override
    public PublicacionDtoRespuesta obtenerPublicacionPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarPublicacion(Long id) {
        
    }

    @Override
    public void modificarPublicacion(Long id, PublicacionDtoCreacional publicacionDtoCreacional) {
        
    }

    
    
}
