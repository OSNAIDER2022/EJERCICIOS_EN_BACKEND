package template;

public class ContadorEmpleadosContratados extends Contador{
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double respuesta = 0.0;
        //se debe realizar un casteo para acceder a los atributos de la clase EmpleadosContratados
        if(empleado instanceof EmpleadoContratado){
            EmpleadoContratado emp = (EmpleadoContratado) empleado;
            respuesta = emp.getValorPorHoras()*emp.getCantidadDeHoras();
            return respuesta;
        }else {
            return respuesta;
        }

    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion es un documento digital.";
    }
}
