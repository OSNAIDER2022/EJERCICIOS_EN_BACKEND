package ejemplo_buffer;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        //preparar la lista
        List<Perro> perroList = new ArrayList<>();
        perroList.add(new Perro("toby", 2));
        perroList.add(new Perro("matias", 5));
        perroList.add(new Perro("rocky", 1));
        perroList.add(new Perro("max", 3));

        //guardar la lista
        GestorDeListasDePerros.guardarArchivo(perroList);

        //recuperar la lista
        List<Perro> perrosRecuperados = GestorDeListasDePerros.recuperarArchivo();

        //mostrar los elementos de la lista
        for (Perro perro: perrosRecuperados) {
            System.out.println(perro);
        }
    }
}
