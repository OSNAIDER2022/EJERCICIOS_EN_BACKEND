package facade;

public class Producto {
    //ATRIBUTOS
    private String nombre;
    private String tipo;

    //CONSTRUCTOR
    public Producto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
