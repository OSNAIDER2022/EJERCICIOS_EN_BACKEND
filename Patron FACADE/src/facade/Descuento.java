package facade;

public interface Descuento {
    int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad);
}
