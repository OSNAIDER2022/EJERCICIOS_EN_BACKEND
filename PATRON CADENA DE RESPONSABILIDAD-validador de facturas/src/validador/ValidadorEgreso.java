package validador;

public class ValidadorEgreso extends Validador{

    @Override
    public String revisarFactura(Factura factura) {
        if(factura.getTipo().equals("egreso")){
            System.out.println("procesada como EGRESO");
                    return "La factura será enviada a la base de datos de EGRESO";
        }else{
            return getSiguienteValidador().revisarFactura(factura);
        }
    }
}
