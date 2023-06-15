package software_laboratorio.model;

import java.time.LocalDate;

public class Paciente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private LocalDate fechaDeIngreso;
    private Domicilio domicilio;

    //CONSTRUCTORES:
    //con id
    public Paciente(Integer id, String nombre, String apellido, String identificacion, LocalDate fechaDeIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
    }

    //sin id:
    public Paciente(String nombre, String apellido, String identificacion, LocalDate fechaDeIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
    }

    //GETTERS AND SETTERS:

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
