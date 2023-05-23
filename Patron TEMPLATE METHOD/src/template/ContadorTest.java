package template;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContadorTest {
    @Test
    public void  liquidacionDeEmpleadoContratado(){
        Empleado Juan  = new EmpleadoContratado("Juan Sanchez","7wdu83999ei",34,10.0);
        Contador contador1 = new ContadorEmpleadosContratados();

        String respuestaEsperada = "La liquidacion es un documento digital." + " Sueldo a liquidar: " + 340.0;
        String respuestaActual = contador1.liquidarSueldo(Juan);

        Assertions.assertEquals(respuestaActual, respuestaEsperada);

    }
}
