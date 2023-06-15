package template;

public abstract class Contador {
    public String liquidarSueldo(Empleado empleado){
        String respuesta = "La liquidacion no pudo ser calculada";
        Double sueldo = calcularSueldo(empleado);
        if(sueldo>0){
            String recibo = emitirRecibo(empleado);
            String deposito = depositarSueldo(empleado);
            respuesta = recibo + " Sueldo a liquidar: " + sueldo;
            return respuesta;
        }
        return respuesta;
    }
    private String depositarSueldo(Empleado empleado){
        return "Orden de deposito en la cuenta: " + empleado.getCuentaBancaria();
    }
    protected abstract Double calcularSueldo(Empleado empleado);
    protected  abstract  String emitirRecibo(Empleado empleado);
}
