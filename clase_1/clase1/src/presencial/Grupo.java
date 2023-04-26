package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    //ATRIBUTOS
    private List<Persona> personas;

    public Grupo(){
        personas = new ArrayList<>();
    }
    //METODOS

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersonas(Persona persona){
        //establecemos la validacion para poder agregar una persona al grupo si cumple con todas las caracterizaciones
        boolean checkMayoriaEdad = persona.esMayorDeEdad();
        boolean cantidadLetras = persona.checkNombre4Letras();
        boolean soloLetras = persona.checkLetrasAtoZ();
        boolean checkEdad = persona.checkEdad();

        if(checkMayoriaEdad && cantidadLetras && soloLetras && checkEdad){
            personas.add(persona);
            System.out.println("La persona: "+ persona.getNombre() + " ha sido agregada satisfactoriamente");
        }else{
            System.err.println("Lo sentimos !! la persona: "+persona.getNombre()+" no puede ser agregada al Grupo");
        }
    }
}
