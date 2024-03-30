public class Main {
    public static void main(String[] args) {
        /*Contrario de lo que sucede con Break, Continue lo usamos para interrumpir el flujo
        * normal del programa y de este modo, ejecutar otra accion alterna antes de volver al
        * flujo principal*/

        int b = 0;
        while (true){
            /*cuando la iteración llega a 5, se sigue ejecutando en segundo plano, sin
            * mostrarse en pantalla, hasta llegar a 15, que es el rango final establecido
            * en la condición*/
            if(b >= 5 && b <= 10){
                /*establecemos el contador para continuar con la secuencia del flujo
                * principal*/
                b++;
                /*codigo alterno que queremos mostrar*/
                System.out.println("ejecución del flujo Continue");
                continue;
            }
            //mientras no se cumpla la condición del continue, esta linea se verá
            System.out.println("El valor de B es: " + b);
            //establecemos el break para el fin del bucle infinto
            if(b == 20)
                break;
            b++;
        }
        System.out.println("Fin del programa!!");
    }
}