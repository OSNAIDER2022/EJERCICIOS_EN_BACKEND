public class Main {
    public static void main(String[] args) {
        /*Los valores de tipo float pueden expresarse de las siguientes maneras:*/
        //colocando una F o f al final del número
        float myFloat;
        myFloat = 13F;
        System.out.println("El número flotante '13F', es: " + myFloat);
        myFloat =56f;
        System.out.println("El número flotante '56f', es: " + myFloat);

        //casteando el número, cambiandolo de Integer a Float directamente
        myFloat = (float) 89;
        System.out.println("El número flotante '(float) 89', es: " + myFloat);

        //haciendo uso de Double:
        Double myDouble;
        myDouble = 0.7682;
        System.out.println("El número flotante '0.7682' usando Double, es: " + myDouble);

        //convirtiendo el numero directamente a Double usando la D o d
        myDouble = 45D;
        System.out.println("El número flotante '45D' es: " + myDouble);
        myDouble = 32d;
        System.out.println("El número flotante '32d' es: " + myDouble);
    }
}