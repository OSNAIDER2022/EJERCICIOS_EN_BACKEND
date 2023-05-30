package ejemplo_buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorDeListasDePerros {
    public static void guardarArchivo(List<Perro> canes) {
        FileOutputStream fileOutputStream = null;
        try {
            //creamos el archivo
            fileOutputStream = new FileOutputStream("canes.txt");

            //necesitamos una forma de pasar la lista al archivo. El "ObjectOutputStream" necesita un "FileOutputStream"
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(canes);
            objectOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Perro> recuperarArchivo() {
        FileInputStream fileInputStream = null;
        List<Perro> respuesta = null;

        try {
            //se pasa el archivo que se pretende leer:
            fileInputStream = new FileInputStream("canes.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //se castea hacia un ArrayList
            respuesta = (ArrayList)objectInputStream.readObject();
            objectInputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

}
