package ejemplo_buffer;

import java.io.Serializable;

public class Perro implements Serializable {
    private String nombre;
    private Integer edad;

    //CONSTRUCTOR:
    public Perro(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //se debe realizar un TO STRING para aplicar esto:
    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
