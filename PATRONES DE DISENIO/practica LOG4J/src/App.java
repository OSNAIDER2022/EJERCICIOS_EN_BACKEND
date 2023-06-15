import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class App {
    //con este atributo iniciamos el loggeo
    private  static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaDeEnteros;
    public App(){
        listaDeEnteros = new ArrayList<>();
    }
    public void agregarEntero(Integer numeroEntero){
        listaDeEnteros.add(numeroEntero);
        //se establece condicional para validar el tamaño de "listaEnteros"
        if (listaDeEnteros.size()>10){
            logger.info("INFORMACION: Tenés más de 10 numeros enteros en tu lista de Enteros." + " Has ingresado el numero: " + numeroEntero);
        }if (listaDeEnteros.size()>5){
            logger.info("INFORMACION: Tenés más de 05 numeros enteros en tu lista de Enteros." + " Has ingresado el numero: " + numeroEntero);
        }
    }

}
