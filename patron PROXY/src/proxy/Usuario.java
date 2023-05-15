package proxy;

public class Usuario {
    //ATRIBUTOS
    private String nombre;
    private String role;

    //CONTRUCTOR
    public Usuario(String nombre, String role) {
        this.nombre = nombre;
        this.role = role;
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
