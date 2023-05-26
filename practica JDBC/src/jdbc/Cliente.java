package jdbc;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.h2.util.JdbcUtils.getConnection;

public class Cliente {
    public static void main(String[] args){
        //conectamos con la DB por primera vez
        Connection connection = null;
        try {
            connection = getConnection();
            //preparamos la TABLA
            Statement statement = connection.createStatement();
            //borramos la tabla si hay alguna existentes y creamos una nueva tabla en caso qeu no lo haya. Esto lo lograremos mediante el usso de "Statement"
            statement.execute("DROP TABLE IF EXISTS ANIMALES" +
                    "CREATE TABLE ANIMALES(ID INT PRYMARI KEY, NOMBRE VARCHAR (100) NOT NULL, TIPO VARCHAR(10)NOT NULL)");
        }catch (Exception e){
            e.printStackTrace();
        }

    //ESTABLECEMOS LA CONEXION:
    public static Connection getConnection(){
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/baseDedatos", "root", "root");
    }
}

    private static Connection getConnection() {
    }
