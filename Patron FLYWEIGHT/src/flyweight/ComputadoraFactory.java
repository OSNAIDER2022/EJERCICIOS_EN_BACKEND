package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private static Map<String, Computadora> computadoraMap;
    public ComputadoraFactory(){
        computadoraMap = new HashMap<>();
    }
    public Computadora getComputadora(Integer memoriaRam, Integer almacenamiento){
        //1. se arma la key
        String clave = "a" + memoriaRam + ":" + almacenamiento;

        //2. se valida si la key existe
        if(!computadoraMap.containsKey(clave)){
            //3. si existe la key se devuelve el valor asociado. En caso contrario procede a crear un objeto en el Map y luego devolvemos
            computadoraMap.put(clave, new Computadora(memoriaRam, almacenamiento));

        }
        return computadoraMap.get(clave);
    }
}
