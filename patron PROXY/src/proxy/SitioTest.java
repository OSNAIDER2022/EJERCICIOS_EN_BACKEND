package proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SitioTest {
    @Test
    public void casoCorrectoAdmin(){
        //DADO
        Usuario usuarioAdmin = new Usuario("Albeiro","admin");
        SitioProxy sitioPrueba = new SitioProxy();

        String respuestaEsperada = "El usuario puede acceder a todos los sitios";

        //CUANDO
        String respuestaActual = sitioPrueba.ingresarAlSitio(usuarioAdmin);

        //ENTONCES
        Assertions.assertEquals(respuestaEsperada, respuestaActual);
    }

    @Test
    public void casoCorrectoColaborador(){
        Usuario usuarioColaborador = new Usuario("Jaime", "colaborador");
        SitioProxy sitioPrueba2 = new SitioProxy();

        String respuestaEsperada = "el usuario no tiene permisos para ingresar al SITIO C";
        String respuestaActual = sitioPrueba2.ingresarAlSitio(usuarioColaborador);

        Assertions.assertEquals(respuestaActual, respuestaEsperada);
    }

    @Test
    public void casoCorrectoCliente(){
        Usuario usuarioCliente = new Usuario("Carolina","cliente");
        SitioProxy sitioPrueba3 = new SitioProxy();

        String respuestaEsperada = "el usuario no tiene permisos para ingresar a los SITIOS B y C";
        String respuestaActual = sitioPrueba3.ingresarAlSitio(usuarioCliente);

        Assertions.assertEquals(respuestaActual, respuestaEsperada);
    }
}
