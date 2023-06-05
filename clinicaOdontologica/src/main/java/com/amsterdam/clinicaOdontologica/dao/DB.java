package com.amsterdam.clinicaOdontologica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static final String SQL_DROP_CREATE_TABLES = "DROP TABLE IF EXISTS PACIENTES, DOMICILIOS;"+
            "CREATE TABLE DOMICILIOS(ID INT AUTO_INCREMENT, CALLE VARCHAR(100) NOT NULL, NUMERO VARCHAR(100) NOT NULL, LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL, PRIMARY KEY(ID));"+
            "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, IDENTIFICACION VARCHAR(100) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL, EMAIL VARCHAR(100) NOT NULL, PRIMARY KEY(ID));";

    private static final String SQL_DE_PRUEBAS = "INSERT INTO PACIENTES(NOMBRE, APELLIDO, IDENTIFICACION, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES('Jeremy','Hantzel','67dhh5h56','2022-11-15',1,'prueba1@gmail.com');";



    public static void crearTablas(){
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_TABLES);
            statement.execute(SQL_DE_PRUEBAS);
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
        return DriverManager.getConnection("jdbc:h2:~/github/EJERCICIOS_EN_BACKEND/clinicaOdontologica/src/main/resources/clinicadb","root","toor");
    }
}
