package com.example.quicklunchapp.model;

import java.io.Serializable;

public class Ticket implements Serializable {

    private String id;
    private String idEstudiante;
    private String idPlato;
    private String nombreEstudiante;
    private String codigoEstudiante;
    private String nombrePlato;
    private String descripcion;
    private String bebida;
    private String postre;
    private String comentario;

    public Ticket(String id, String idEstudiante, String idPlato, String nombreEstudiante, String codigoEstudiante, String nombrePlato, String descripcion, String bebida, String postre, String comentario) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idPlato = idPlato;
        this.nombreEstudiante = nombreEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.bebida = bebida;
        this.postre = postre;
        this.comentario = comentario;
    }

    public Ticket() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


}
