package com.amsterdam.registro_de_casos.model;

public class SoporteTecnico {
    //ATRIBUTOS:
    private Integer id;
    Usuario usuario;
    Equipo equipo;
    Servicio servicio;
    private String asunto;
    private String descripcion;
    private String observaciones;

    //CONSTRUCTOR
    //CON ID:
    public SoporteTecnico(Integer id, Usuario usuario, Equipo equipo, Servicio servicio, String asunto, String descripcion, String observaciones) {
        this.id = id;
        this.usuario = usuario;
        this.equipo = equipo;
        this.servicio = servicio;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
    }

    //SIN ID:
    public SoporteTecnico(Usuario usuario, Equipo equipo, Servicio servicio, String asunto, String descripcion, String observaciones) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.servicio = servicio;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
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
}
