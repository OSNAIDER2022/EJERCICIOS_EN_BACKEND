import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Los Array List son una de las formas más sencillas de crear y modificar listas
        //ya que permite la manipulacion en su totalidad sobre los elementos de un Array.
        //para trabajar con ellas, debemos seguir la siguiente estructura:
        //ArrayList<tipo> nombreArray = new ArrayList<>();

        ArrayList<String> autosList = new ArrayList<>();

        //podemos agregar elementos con .add
        autosList.add("Mazda");
        autosList.add("Chevrolet");
        autosList.add("Audi");

        //podemos ver su contenido sin necesidad de un loop
        System.out.println("El contenido de autosList, es: " + autosList);

        //podemos saber el tamaño del Array
        System.out.println("El tamaño del Array autosList, es: " + autosList.size());

        //podemos indicar en qué posición del Array en la que deseamos agregar un elemento
        autosList.add(1,"Honda");
        System.out.println("El contenido de autosList, después de agregar Honda: " + autosList);


    }
}