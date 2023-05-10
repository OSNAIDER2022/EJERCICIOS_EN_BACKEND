package listaDePersonas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoTest {
    @Test
    public void grupoDeDosPersonas(){
        //DADO: Van todos los datos iniciales
        Persona juan = new Persona("Juan", 20);
        Persona natali = new Persona("Natali", 10);
        Persona yailu = new Persona("Yailu", 45);
        Persona susana = new Persona("Susana", 80);
        Persona camilo = new Persona("Camilo", 121);
        Persona guillermo = new Persona("Guillermo", 29);

        Grupo grupoPrueba = new Grupo();

        //CUANDO: Va el proceso a probar
        grupoPrueba.agregarPersona(juan);
        grupoPrueba.agregarPersona(natali);
        grupoPrueba.agregarPersona(yailu);
        grupoPrueba.agregarPersona(susana);
        grupoPrueba.agregarPersona(camilo);
        grupoPrueba.agregarPersona(guillermo);

        //ENTONCES: Laa prueba lógica que muestra OK
        Assertions.assertTrue(grupoPrueba.getPersonas().size()==2);
    }
}
