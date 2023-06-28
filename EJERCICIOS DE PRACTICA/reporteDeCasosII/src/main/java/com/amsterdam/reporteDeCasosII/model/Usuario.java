package com.amsterdam.reporteDeCasosII.model;

public class Usuario {
    //ATRIBUTOS:
    private Integer id;
    private String nombreCompleto;
    private String numeroCelular;
    private String correo;

    //CONSTRUCTORES
    //CON ID:
    public Usuario(Integer id, String nombreCompleto, String numeroCelular, String correo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
    }

    //SIN ID:
    public Usuario(String nombreCompleto, String numeroCelular, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
    }

    //VACIO MARCADO POR DEFAULT:
    public Usuario() {

    }

    //GETTERS AND SETTERS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
