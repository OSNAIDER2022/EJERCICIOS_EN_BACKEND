package validador;

public class ValidadorInversion extends Validador{
    @Override
    public String revisarFactura(Factura factura) {
        if(factura.getTipo().equals("inversion")){
            System.out.println("procesada como INVERSION");
            return "La factura será enviada a la base de datos de INVERSION";
        }else{
            return getSiguienteValidador().revisarFactura(factura);
        }
    }

}
