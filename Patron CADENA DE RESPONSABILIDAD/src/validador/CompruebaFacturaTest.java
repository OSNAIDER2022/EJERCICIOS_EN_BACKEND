package validador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CompruebaFacturaTest {
    @Test
    public void facturaAInversion(){
        //dado
        CompruebaFactura heladitos = new CompruebaFactura();
        Factura factura = new Factura("egreso","compra de helados para eventos",1135000,"osnaider palomino");
        String respuestaEsperada = "La factura será enviada a la base de datos de EGRESO";
        //cuando
        String respuestaActual = heladitos.compruebaFactura(factura);
        //entonces
        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }

}
