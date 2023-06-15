package facade;

public class ApiCantidad {
    public static int descuentoPorCantidad(int cantidad){
        if(cantidad>12){
            return 15;
        }else {
            return 0;
        }
    }
}
