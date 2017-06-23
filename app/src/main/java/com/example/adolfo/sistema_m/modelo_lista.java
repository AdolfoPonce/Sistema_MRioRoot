package com.example.adolfo.sistema_m;

/**
 * Created by adolfo on 21/06/17.
 */

public class modelo_lista {
    private String titulo;
    private String descripcion;
    public modelo_lista(){}

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    String getTitulo(){
        return titulo;
    }
    String getDescripcion(){
        return descripcion;
    }
}
