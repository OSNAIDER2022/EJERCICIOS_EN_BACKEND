package presencial;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GrupoTest {
    @Test
    public void grupoDe2Personas(){
        //parte DADA: Van todos los datos iniciales del test
        Persona juan = new Persona("Juan",20);
        Persona pedro = new Persona("Pedro",21);
        Persona ana = new Persona("Ana",22);
        Persona luz = new Persona("Luz",23);
        Persona julian = new Persona("Julian",24);

        Grupo grupo1 = new Grupo();

        // parte CUANDO: Determina el proceso a probar
        grupo1.agregarPersonas(juan);
        grupo1.agregarPersonas(pedro);
        grupo1.agregarPersonas(ana);
        grupo1.agregarPersonas(luz);
        grupo1.agregarPersonas(julian);

        // parte ENTONCES: Estipula la prueba logica que indica que la prueba está OK
        Assertions.assertTrue(grupo1.getPersonas().size() == 2);
    }
}
