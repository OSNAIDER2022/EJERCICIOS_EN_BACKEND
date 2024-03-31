import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Los Strings se pueden usar de las siguientes formas:*/
        //almacenando directamente su valor String en una variable
        String myString;
        myString = "JAVA STRINGS!!";
        System.out.println("El valor almacenado de forma simple en la variable myString: " + myString);

        //utilizando interactividad con el usuario:
        Scanner scanner = new Scanner(System.in);
        myString = scanner.next();
        System.out.println("El valor almacenado de forma interactiva en la variable myString: " + myString);

        //usando una concadenación con el simbolo '+'
        myString = "JAVA STRINGS!!" + " " + "... y otros caracteres concadenados";
        System.out.println("El valor almacenado de forma concadenada en la variable myString: " + myString);

        /*usando los elementos de un array de tipo Char y formar una concatenación con el constructor
        * por defecto de Java para String*/
        char[] arrayChar = {'S','t','r','i','n','g'};
        String myStringCreated = new String(arrayChar);
        System.out.println("El valor almacenado de forma de array Char y creado mediante el constructor new String (constructor por defecto de Java) en la variable myStringCreated: " + myStringCreated);
    }
}