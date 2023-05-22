package facade;

public class Cliente {
    public static void main(String[] args) {
        //fachada
        FacadeDescuento fachada = new FacadeDescuento();

        //datos de inicio
        Tarjeta tarjeta = new Tarjeta("4682738484", "START BANK");
        Producto producto = new Producto("Tomates en conserva", "LATAS");
        int cantidad = 20;

        //imprimimos el valor en pantalla:
        System.out.println("Total de descuento: " + fachada.calcularDescuento(tarjeta, producto,cantidad));

    }
}
