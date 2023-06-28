package com.amsterdam.reporteDeCasosII.model;

public class Equipo {
    //ATRIBUTOS:
    private Integer id;
    private String modelo;
    private String serial;

    //CONSTRUCTORES
    //CON ID:
    public Equipo(Integer id, String modelo, String serial) {
        this.id = id;
        this.modelo = modelo;
        this.serial = serial;
    }

    //SIN ID:
    public Equipo(String modelo, String serial) {
        this.modelo = modelo;
        this.serial = serial;
    }

    //GETTERS AND SETTERS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}