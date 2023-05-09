package validador;
//este será la aceptacion por defecto la cual no tendrá validacion
public class ValidadorIngreso extends Validador{
    @Override
    public String revisarFactura(Factura factura) {
        System.out.println("procesada como INGRESO");
        return "La factura será enviada a la base de datos de INGRESO";
    }
}
