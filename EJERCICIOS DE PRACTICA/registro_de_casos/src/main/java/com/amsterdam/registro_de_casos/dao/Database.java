package com.amsterdam.registro_de_casos.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    //ATRIBUTOS:
    private static final String SQL_DROP_CREATE = "DROP TABLE IF  EXIST usuarios, equipos, servicios, soportesTecnicos;"+
            "CREATE TABLE usuarios(id INT PRIMARY KEY AUTO_INCREMENT, nombreCompleto VARCHAR(100) NOT NULL, numeroCelular VARCHAR(100) NOT NULL, correo VARCHAR(100) NOT NULL);"+
            "CREATE TABLE equipos(id INT PRIMARY KEY AUTOINCREMENT, modelo VARCHAR(100) NOT NULL, serial VARCHAR(100) NOT NULL);"+
            "CREATE TABLE servicios(id INT PRIMARY KEY AUTO_INCREMENT, nombreDeServicio VARCHAR(100) NOT NULL, descripcion MEDIUMTEXT NOT NULL, precio DOUBLE NOT NULL);"+
            "CREATE TABLE soportesTecnicos(id INT PRIMARY KEY AUTO_INCREMENT, fecha DATE NOT NULL, asunto VARCHAR(100) NOT NULL, descripcion LONGTEXT NOT NULL, observaciones MEDIUMTEXT NOT NULL, usuario_id INT NOT NULL, servicio_id INT NOT NULL, equipo_id INT NOT NULL);";

    //METODOS
    public static void crearTablas(){
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE);

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("~/github/EJERCICIOS_EN_BACKEND/EJERCICIOS DE PRACTICA/registro_de_casos/src/main/resources/Databases/");
    }
}
