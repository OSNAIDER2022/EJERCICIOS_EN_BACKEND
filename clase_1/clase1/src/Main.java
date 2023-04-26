import presencial.Grupo;
import presencial.Persona;

public class Main {
    public static void main(String[] args) {
        //declaramos las personas
        Persona camila = new Persona("Camila",20);
        Persona samuel = new Persona("Samuel",14);
        Persona andres = new Persona("4ndres",30);
        Persona claudia = new Persona("Claudia",220);

        //declaramos el Grupo
        Grupo grupo_n1 = new Grupo();
            grupo_n1.agregarPersonas(camila);
            grupo_n1.agregarPersonas(samuel);
            grupo_n1.agregarPersonas(andres);
            grupo_n1.agregarPersonas(claudia);
    }
}