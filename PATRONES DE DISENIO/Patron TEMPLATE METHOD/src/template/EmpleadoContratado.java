package template;

public class EmpleadoContratado extends Empleado{
    //ATRIBUTOS PROPIOS
 private Integer cantidadDeHoras;
 private Double valorPorHoras;

 //CONSTRUCTOR
    public EmpleadoContratado(String nombreEmpleado, String cuentaBancaria, Integer cantidadDeHoras, Double valorPorHoras) {
        super(nombreEmpleado, cuentaBancaria);
        this.cantidadDeHoras = cantidadDeHoras;
        this.valorPorHoras = valorPorHoras;
    }

    //GETTERS AND SETTERS
    public Integer getCantidadDeHoras() {
        return cantidadDeHoras;
    }

    public void setCantidadDeHoras(Integer cantidadDeHoras) {
        this.cantidadDeHoras = cantidadDeHoras;
    }

    public Double getValorPorHoras() {
        return valorPorHoras;
    }

    public void setValorPorHoras(Double valorPorHoras) {
        this.valorPorHoras = valorPorHoras;
    }
}
