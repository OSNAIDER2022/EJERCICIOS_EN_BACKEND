package facade;

public class FacadeDescuento implements Descuento {
    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuento = 0;
        descuento = descuento + ApiTarjeta.descuentoPorTarjeta(tarjeta);
        descuento = descuento + ApiProducto.descuentoPorProducto(producto);
        descuento = descuento + ApiCantidad.descuentoPorCantidad(cantidad);
        return descuento;
    }
}
