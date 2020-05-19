package com.example.quicklunchapp.model;

import java.io.Serializable;

public class Plato implements Serializable {

    private String id;
    private String nombre;
    private String descripcion;
    private String bebida;
    private String postre;
    private String url;

    public Plato(String id, String nombre, String descripcion, String bebida, String postre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bebida = bebida;
        this.postre = postre;
        this.url = url;
    }

    public Plato() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
