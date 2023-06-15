package template;

public class EmpleadoEfectivo extends Empleado{
    //ATRIBUTOS PROPIOS
    private Double sueldoBasico;
    private Double descuento;
    private Double premio;

    //CONSTRUCTOR
    public EmpleadoEfectivo(String nombreEmpleado, String cuentaBancaria, Double sueldoBasico, Double descuento, Double premio) {
        super(nombreEmpleado, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
        this.descuento = descuento;
        this.premio = premio;
    }


    //GETTERS AND SETTERS
    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }
}
