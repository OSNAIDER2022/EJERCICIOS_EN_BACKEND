package com.amsterdam.reporteDeCasosII.model;

import java.time.LocalDate;

public class SoporteTecnico {
    //ATRIBUTOS:
    private Integer id;
    Usuario usuario;
    Equipo equipo;
    Servicio servicio;
    private String asunto;
    private String descripcion;
    private String observaciones;
    private LocalDate fecha;

    //CONSTRUCTOR
    //CON ID:
    public SoporteTecnico(Integer id, Usuario usuario, Equipo equipo, Servicio servicio, String asunto, String descripcion, String observaciones, LocalDate fecha) {
        this.id = id;
        this.usuario = usuario;
        this.equipo = equipo;
        this.servicio = servicio;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    //SIN ID:
    public SoporteTecnico(Usuario usuario, Equipo equipo, Servicio servicio, String asunto, String descripcion, String observaciones, LocalDate fecha) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.servicio = servicio;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
