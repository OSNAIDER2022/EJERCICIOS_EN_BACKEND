public class Main {
    public static void main(String[] args) {
        boolean boolean1, boolean2, result;
        boolean1 = true;
        boolean2 = false;

        //Devuelve true cuando al menos uno de los valores es true;
        result = boolean1 || boolean2;
        System.out.println("El resultado de || es: " + result);

        //Devuelve true cuando ambos o todos los valores son true;
        result = boolean1 && boolean2;
        System.out.println("El resultado de && es: " + result);
    }
}