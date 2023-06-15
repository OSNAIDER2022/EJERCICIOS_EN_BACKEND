package flyweight;

public class Cliente {
    public static void main(String[] args){
        ComputadoraFactory fabrica= new ComputadoraFactory();
        Computadora pc1 = fabrica.getComputadora(8,480);
        Computadora pc2 = fabrica.getComputadora(16, 125);
        //En esta creacion, al tratarse de los mismos valores de la pc1 traerá lo almacenado en el mismo espacio de memoria del pc1
        Computadora pc3 = fabrica.getComputadora(8,480);
        Computadora pc4 = fabrica.getComputadora(8,256);

        //Mostramos los objetos por pantalla invocando el toString:
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);
        System.out.println(pc4);
        
    }
}
