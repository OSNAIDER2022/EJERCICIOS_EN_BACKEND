public class Main {
    /*Las funciones en Java se pueden establecer en 02 categorias:
     * */

    public static Integer suma(Integer a, Integer b) {
        Integer result;
        result = a + b;
        return result;
    }

    /*La siguiente función corresponde a un programa que hace un calculo factorial de cualquier
    * numero*/
    /*PD: Un Factorial, es la multiplicacion de un numero N entre todos los numeros existentes
    entre N hasta el numero 1.
    * Se usa mayormente para aplicaciones estadísticas como numero de combinaciones de un grupo
    * de elementos y demás
    * su fórmula se expresa de la siguiente forma:*/
    // n! = n * (n - 1)* ...*1
    public static Integer calculoFactorial(Integer c) {
        Integer result;

        /*como calcular el factorial de 0 es ilógico, establecemos una validación de que
        * el numero C debe ser mayor o igual a 1*/
        if(c <= 1)
            return c;

        /*después de la validación, ejecutamos la operación*/
        result =  c*calculoFactorial(c-1);

        return result;
    }

    /*Main, sitio donde se llamará a las funciones*/
        public static void main (String[]args){

            Integer resA;

            resA = suma(55,34);
            System.out.println("La suma simple entre A y B, es: " + resA);

            Integer resB;
            Integer c = 3;
            resB = calculoFactorial(c);
            System.out.println("El calculo factorial de " + c + ", es: " + resB);
        }
}
