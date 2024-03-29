public class Main {
    public static void main(String[] args) {
        boolean result;
        //devuelve true si las comparaciones son exactamente iguales:
        result = (10 ==10);
        System.out.println("El resultado de == es: " + result);

        //devuelve true si una de las comparaciones es menor que otra:
        result = (10 < 10);
        System.out.println("El resultado de < es: " + result);

        //devuelve true si una de las comparaciones es mayor que otra:
        result = (10 > 10);
        System.out.println("El resultado de > es: " + result);

        //devuelve true si una de las comparaciones es menor que o igual, que otra:
        result = (10 <= 10);
        System.out.println("El resultado de <= es: " + result);

        //devuelve true si una de las comparaciones es mayor que o igual, que otra:
        result = (10 >= 10);
        System.out.println("El resultado de >= es: " + result);

        //devuelve true si las comparaciones no son exactamente iguales:
        result = (10 != 10);
        System.out.println("El resultado de != es: " + result);

    }
}