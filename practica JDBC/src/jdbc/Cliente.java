package jdbc;

import java.sql.*;

public class Cliente {
    public static void main(String[] args) {
        //Por buena practica, evitamos que la DB se inicie por defecto:
        Connection connection = null;
        try {
            //Generamos la conexion:
            connection = getConnection();
            //Preparamos la tabla:
            Statement statement = connection.createStatement();
            //Borramos la tabla si hay alguna existentes y creamos una nueva tabla en caso que no la haya. Esto lo lograremos mediante el usso de "Statement":
            statement.execute("DROP TABLE IF EXISTS ANIMALES;" +
                    "CREATE TABLE ANIMALES(ID INT PRIMARY KEY, NOMBRE VARCHAR (100) NOT NULL, TIPO VARCHAR(10)NOT NULL);");
            System.out.println("Se ha creado la tabla: ANIMALES");
            //Insertamos los datos de 05 animales:
            statement.execute("INSERT INTO ANIMALES VALUES(1,'JIRAFA','MAMIFERO'),(2,'AGUILA','AVE'),(3,'PULPO','MOLUSCO'),(4,'IGUANA','REPTIL'),(5,'PERRO','MAMIFERO');");
            System.out.println("Se han insertado 05 animales a la tabla");
            //Mostramos la tabla. Para ello agregamos ResultSet:
            ResultSet showAdd = statement.executeQuery("SELECT * FROM ANIMALES;");
            //mostramos por pantalla:
            while (showAdd.next()) {
                System.out.println("Nombre: " + showAdd.getString(2) + " - Tipo: " + showAdd.getString(3));
            }
            System.out.println("Se ha mostrado el contenido de la tabla ANIMALES");
            System.out.println("============================================================================================ ");
            //Borramos un animal y mostramos de nuevo la tabla:
            statement.execute("DELETE FROM ANIMALES WHERE ID = 1;");
            System.out.println("Se ha eliminado 01 animal de la tabla");
            ResultSet showDelete = statement.executeQuery("SELECT * FROM ANIMALES;");
            //mostramos por pantalla:
            while (showDelete.next()) {
                System.out.println("Nombre: " + showDelete.getString(2) + " - Tipo: " + showDelete.getString(3));
            }
            System.out.println("fin de la ejecucion");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ESTABLECEMOS LA CONEXION:
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/github/EJERCICIOS_EN_BACKEND/practica JDBC/src/jdbc]", "root", "toor");
    }
}


