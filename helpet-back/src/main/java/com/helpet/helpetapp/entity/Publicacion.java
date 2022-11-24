package com.helpet.helpetapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "publicaciones")
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "La url de la imagen no debe estar vacia o nula.")
    @Size(max = 200)
    private String imagen;

    @NotEmpty(message = "La descripcion no debe estar vacia o nula.")
    @Size(max = 1000)
    private String descripcion;

    @Column(name = "fecha_de_publicacion",length = 50,nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDePublicacion;

    @NotEmpty(message = "La locacion no debe estar vacia o ser nula.")
    @Size(max = 100)
    private String locacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    Estado estado;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "publicacion")
    List<Comentario> comentarios = new ArrayList<Comentario>();
}
