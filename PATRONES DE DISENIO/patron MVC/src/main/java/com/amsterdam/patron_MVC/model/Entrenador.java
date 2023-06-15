package com.amsterdam.patron_MVC.model;

public class Entrenador {
    //ATRIBUTO
    private String nombre;

    //CONSTRUCTOR:
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    //GETTERS AND SETTERS:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
