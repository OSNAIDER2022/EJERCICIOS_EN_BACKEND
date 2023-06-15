package template;

public class ContadorEmpleadosEfectivos extends Contador{
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double respuesta = 0.0;
        //se debe realizar un casteo para acceder a los atributos de la clase EmpleadosEfectivos
        if (empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo emp = (EmpleadoEfectivo) empleado;
            respuesta = emp.getSueldoBasico()+emp.getPremio()-emp.getDescuento();
            return respuesta;
        }else{
            return respuesta;
        }
    }
    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion generada es un documento escrito";
    }
}
