public class Main {
    public static void main(String[] args) {
        //Los Break Statements cortan la operación y/o ejecucion de un programa, siempre que
        //se cumpla la condición de break

        //se inicializa en 0 la variable a iterar
        int a = 0;

        //se establece un bucle infinito mediante while(true)
        while (true){
            System.out.println("El valor de A es: " + a);

            //establecemos la condicional para el break
            if(a == 10)
                break;
            a++;
        }
        System.out.println("Fin del programa!");
    }
}