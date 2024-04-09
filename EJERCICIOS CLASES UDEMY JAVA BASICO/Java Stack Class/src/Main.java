import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    /*Los stacks son arrays de pila cuya gran particularidad es la de permitir el llamado
    * o la recuperación del último elemento almacenado en ellas*/

        //Estas pueden ser de tipo entero, string, double
        Stack<Integer> myStackInteger = new Stack<>();
        Stack<String> myStackString = new Stack<>();
        Stack<Double> myStackDouble = new Stack<>();

        //los elementos se insertan mediante el método PUSH:
        myStackInteger.push(2);
        myStackInteger.push(4);
        myStackInteger.push(67);
        myStackInteger.push(7);
        myStackInteger.push(9);
        myStackInteger.push(7);
        myStackInteger.push(8);

        myStackString.push("hola");
        myStackString.push("esto");
        myStackString.push("es");
        myStackString.push("una");
        myStackString.push("prueba");

        myStackDouble.push(4.5);
        myStackDouble.push(45.8);
        myStackDouble.push(11.3);

        //mediante el método SIZE conocemos el tamaño del stack:
        System.out.println("El tamaño de myStackInteger es: " + myStackInteger.size());
        System.out.println("El tamaño de myStackString es: " + myStackString.size());
        System.out.println("El tamaño de myStackDouble es: " + myStackDouble.size());

        //con el método PEEK
        System.out.println("no se que hace peek " + myStackInteger.peek());

        //con el método POP, vemos el último elemento agregado
        while (!myStackInteger.isEmpty()){
            System.out.println("ultimo item: " + myStackInteger.pop());
        }
    }
}