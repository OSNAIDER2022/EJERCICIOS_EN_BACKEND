package facade;

public class ApiProducto {
    public static int descuentoPorProducto(Producto producto){
        if(producto.getTipo().equals("LATAS")){
            return 10;
        }else{
            return 0;
        }
    }
}
