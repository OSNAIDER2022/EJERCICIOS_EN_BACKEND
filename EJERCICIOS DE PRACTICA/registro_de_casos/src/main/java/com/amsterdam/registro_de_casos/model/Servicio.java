package com.amsterdam.registro_de_casos.model;

public class Servicio {
    //ATRIBUTOS:
    private Integer id;
    private String nombreDeServicio;
    private String descripcion;
    private double precio;

    //CONSTRUCTORES
    //CON ID:
    public Servicio(Integer id, String nombreDeServicio, String descripcion, double precio) {
        this.id = id;
        this.nombreDeServicio = nombreDeServicio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //SIN ID:
    public Servicio(String nombreDeServicio, String descripcion, double precio) {
        this.nombreDeServicio = nombreDeServicio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDeServicio() {
        return nombreDeServicio;
    }

    public void setNombreDeServicio(String nombreDeServicio) {
        this.nombreDeServicio = nombreDeServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
