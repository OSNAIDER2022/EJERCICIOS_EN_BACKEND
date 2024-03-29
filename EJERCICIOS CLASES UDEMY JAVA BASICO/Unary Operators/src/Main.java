public class Main {
    public static void main(String[] args) {
        Integer numero1, numero2;
        numero1 = 10;

        //operador unario (-): Invierte el signo del valor al cual se asigna.
        numero2 = -numero1;
        System.out.println("El valor de numero1 es: " + numero1 + ", pero al aplicar el operador unitario - cambia a: " + numero2);

        //operador unario (variable++): post-incrementa el valor en 1;
        numero2 =  numero1++;
        System.out.println("El valor de numero1 es: " + numero1 + ", pero al aplicar el operador unitario variable++ cambia a: " + numero2);

        //operador unario (++variable): Pre-incrementa el valor en 1 y luego asigna el valor a la siguiente variable;
        numero2 = ++numero1;
        System.out.println("El valor de numero1 es: " + numero1 + ", pero al aplicar el operador unitario ++variable cambia a: " + numero2);

        //operador unario (--variable): Pre-reduce el valor en 1 y luego asigna el valor a la siguiente variable;
        numero2 = --numero1;
        System.out.println("El valor de numero1 es: " + numero1 + ", pero al aplicar el operador unitario --variable cambia a: " + numero2);

        //operador unario (variable--): Post-reduce el valor en 1;
        numero2 = numero1--;
        System.out.println("El valor de numero1 es: " + numero1 + ", pero al aplicar el operador unitario variable-- cambia a: " + numero2);

        //operador unitario !: invierte el valor booleano de las variables.
        boolean boolean1, boolean2;
        boolean1 = true;
        boolean2 = !boolean1;
        System.out.println("El valor de boolean1 es: " + boolean1 + ", pero al aplicar el operador unitario !boolean cambia a: " + boolean2);
    }
}