package software_laboratorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS MEDICAMENTOS;"+
            "CREATE TABLE MEDICAMENTOS(ID INT PRIMARY KEY, CODIGO VARCHAR(100) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, LABORATORIO VARCHAR(100) NOT NULL, CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL);";

    public static void crearTabla(){
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception{
        //Cargamos el driver H2:
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/github/EJERCICIOS_EN_BACKEND/Patron DAO/src/software_laboratorio","root","toor");
    }
}
