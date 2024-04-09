import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa una letra de la A a la D: ");
        char caracter = scanner.next().charAt(0);

        switch (caracter){
            case 'A' | 'a':
                System.out.println("Este es el saludo al elegir la letra A");
                break;
            case 'B' | 'b':
                System.out.println("Sí has elegido B, de seguro te saldrá esto!!!!");
                break;
            case 'C' | 'c':
                System.out.println("Al elegir C, te has merecido un buen café por la mañana, yo invito ;)");
                break;
            case 'D' | 'd':
                System.out.println("Vaya! no esperaba que eligieras la D!!! pero fúe una muy buena eleción.");
                break;
            default:
                System.out.println("Lo siento, pero no has ingresado una de las letras que te he indicado. Inténtalo de nuevo!!");
                break;
        }
        scanner.close();
        System.out.println("Nos vemos en una próxima ocasión.... bye!!");
    }
}