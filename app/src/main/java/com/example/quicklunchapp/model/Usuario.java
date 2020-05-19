package com.example.quicklunchapp.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String id;
    private String nombre;
    private String codigo;
    private String documentoIdentidad;
    private String clave;

    public Usuario(String id, String nombre, String codigo, String documentoIdentidad, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.documentoIdentidad = documentoIdentidad;
        this.clave = clave;

    }

    public Usuario() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
