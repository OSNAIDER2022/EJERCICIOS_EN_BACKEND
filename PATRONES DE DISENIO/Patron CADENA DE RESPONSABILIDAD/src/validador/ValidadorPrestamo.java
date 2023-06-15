package validador;

public class ValidadorPrestamo extends Validador{
    @Override
    public String revisarFactura(Factura factura) {
        if(factura.getTipo().equals("prestamo")){
            System.out.println("procesada como PRESTAMO");
            return "La factura será enviada a la base de datos de PRESTAMO";
        }else{
            return getSiguienteValidador().revisarFactura(factura);
        }
    }
}
