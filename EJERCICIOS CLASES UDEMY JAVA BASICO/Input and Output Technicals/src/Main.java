import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // INPUT AND OUTPUT TECHNICALS:
        //Los outputs pueden se de tipo:

        //OUTPUT:
        //String:
        System.out.println("Hola de nuevo! soy un String");
        //Entero primitivo (int):
        int a = 10;
        System.out.println("El valor de A es:" + a);
        //ó Entero común (Integer):
        Integer b = 20;
        System.out.println("El valor del B es:" + b);

        //INPUT:
        //La clase Scanner es usada para la entrada de informacion:
        Scanner scanner = new Scanner(System.in);
        System.out.println("PRUEBA DE LA CLASE SCANNER: Ingresa el texto a mostrar de tipo String: ");
        String c = scanner.next();
        System.out.println("El texto a mostrar es: " + c);
        scanner.close();
    }
}