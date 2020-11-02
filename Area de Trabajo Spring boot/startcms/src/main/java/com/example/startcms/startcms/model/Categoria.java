package com.example.startcms.startcms.model;

import java.util.Date;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

public class Categoria {
    
    @NonNull
    private long IdCategoria;

    //@Min(1000)
    //@NotEmpty
    private String Nombre;
    
    private String Descripcion;
    
    private Date FechaCategoria;

    private long CategoriaSuperior;

    public long getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        IdCategoria = idCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFechaCategoria() {
        return FechaCategoria;
    }

    public void setFechaCategoria(Date fechaCategoria) {
        FechaCategoria = fechaCategoria;
    }

    public long getCategoriaSuperior() {
        return CategoriaSuperior;
    }

    public void setCategoriaSuperior(long categoriaSuperior) {
        CategoriaSuperior = categoriaSuperior;
    }

}
