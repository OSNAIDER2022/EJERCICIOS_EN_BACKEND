package template;

public abstract class Empleado {
    //ATRIBUTOS
    private String nombreEmpleado;
    private String cuentaBancaria;

    //CONSTRUCTOR
    public Empleado(String nombreEmpleado, String cuentaBancaria) {
        this.nombreEmpleado = nombreEmpleado;
        this.cuentaBancaria = cuentaBancaria;
    }

    //GETTERS AND SETTERS
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
}
