package com.amsterdam.reporteDeCasosII.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    //ATRIBUTOS:
    private static final String SQL_DROP_CREATE = "CREATE TABLE IF NOT EXISTS usuarios, equipos, servicios, soportesTecnicos;"+
            "CREATE TABLE usuarios (id INT AUTO_INCREMENT PRIMARY KEY, nombreCompleto VARCHAR(100) NOT NULL, numeroCelular VARCHAR(100) NOT NULL, correo VARCHAR(100) NOT NULL);"+
            "CREATE TABLE equipos (id INT AUTOINCREMENT PRIMARY KEY, modelo VARCHAR(100) NOT NULL, serial VARCHAR(100) NOT NULL);"+
            "CREATE TABLE servicios (id INT AUTO_INCREMENT PRIMARY KEY, nombreDeServicio VARCHAR(100) NOT NULL, descripcion MEDIUMTEXT NOT NULL, precio DOUBLE NOT NULL);"+
            "CREATE TABLE soportesTecnicos (id INT AUTO_INCREMENT PRIMARY KEY, usuario_id INT NOT NULL, equipo_id INT NOT NULL, servicio_id INT NOT NULL, asunto VARCHAR(100) NOT NULL, descripcion LONGTEXT NOT NULL, observaciones MEDIUMTEXT NOT NULL, fecha DATE NOT NULL);";

    //METODOS

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/github/EJERCICIOS_EN_BACKEND/EJERCICIOS DE PRACTICA/reporteDeCasosII/src/main/resources/DB/Database","root","toor");
    }
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
}
