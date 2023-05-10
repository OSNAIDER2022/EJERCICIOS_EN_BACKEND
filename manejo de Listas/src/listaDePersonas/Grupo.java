package listaDePersonas;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;
    public Grupo(){
        personas = new ArrayList<>();
    }

   //GETTER
    public List<Persona> getPersonas() {
        return personas;
    }

    //METODO
    public void agregarPersona(Persona persona){
        //realizamos declaracion de variables para facilitar el manejo de la validacion
        boolean a = persona.checkMayorDeEdad();
        boolean b = persona.checkRangoDeEdad();
        boolean c = persona.nombreCuatroCaracteres();
        boolean d = persona.checkSoloLetras();

        //realizamos la validacion
        if(a && b && c && d){
            personas.add(persona);
        }else {
            System.err.println("No se pudo agregar a la persona: "+persona.getNombre());
        }
    }
}
