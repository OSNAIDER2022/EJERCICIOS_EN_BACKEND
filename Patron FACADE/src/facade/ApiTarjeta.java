package facade;

public class ApiTarjeta {
    public static int descuentoPorTarjeta(Tarjeta tarjeta){
        if(tarjeta.getBanco().equals("START BANK")){
            return 20;
        }else{
            return 0;
        }
    }
}
