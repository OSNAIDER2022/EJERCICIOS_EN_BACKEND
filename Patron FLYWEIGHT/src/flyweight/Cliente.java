package flyweight;

public class Cliente {
    public static void main(String[] args){
        ComputadoraFactory fabrica= new ComputadoraFactory();
        Computadora pc1 = fabrica.getComputadora(8,480);
        Computadora pc2 = fabrica.getComputadora(16, 125);
        Computadora pc3 = fabrica.getComputadora(8,480);
        Computadora pc4 = fabrica.getComputadora(8,256);

    }
}
