package com.helpet.helpetapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    private String nombreDelRecurso;
    private String nombreDelCammpo;
    private long valorDelCampo;

    public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCammpo, long valorDelCampo) {
        super(String.format("%s No encontrada con  : %s : '%s'", nombreDelRecurso,nombreDelCammpo,valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCammpo = nombreDelCammpo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCammpo() {
        return nombreDelCammpo;
    }

    public void setNombreDelCammpo(String nombreDelCammpo) {
        this.nombreDelCammpo = nombreDelCammpo;
    }

    public long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }
    
    
}
