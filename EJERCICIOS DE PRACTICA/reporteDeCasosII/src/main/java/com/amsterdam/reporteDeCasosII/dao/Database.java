package com.amsterdam.reporteDeCasosII.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    //ATRIBUTOS:
    private static final String SQL_VERIFY_TABLE_EXISTS = "DROP TABLE IF EXISTS USUARIOS, EQUIPOS, SERVICIOS, SOPORTES_TECNICOS;";
    private static final String SQL_CREATE_TABLE_USUARIOS ="CREATE TABLE IF NOT EXISTS USUARIOS (ID INT NOT NULL AUTO_INCREMENT, NOMBRE_COMPLETO VARCHAR(100) NOT NULL, NUMERO_CELULAR VARCHAR(100) NOT NULL, CORREO VARCHAR(100) NOT NULL, PRIMARY KEY (ID));";
    private static final String SQL_CREATE_TABLE_EQUIPOS ="CREATE TABLE IF NOT EXISTS EQUIPOS (ID INT NOT NULL AUTO_INCREMENT, MODELO VARCHAR(100) NOT NULL, SERIAL VARCHAR(100) NOT NULL, PRIMARY KEY (ID));";
    private static final String SQL_CREATE_TABLE_SERVICIOS ="CREATE TABLE IF NOT EXISTS SERVICIOS (ID INT NOT NULL AUTO_INCREMENT, NOMBRE_DE_SERVICIO VARCHAR(100) NOT NULL, DESCRIPCION MEDIUMTEXT NOT NULL, PRECIO DOUBLE NOT NULL, PRIMARY KEY (ID));";
    private static final String SQL_CREATE_TABLE_SOPORTES_TECNICOS = "CREATE TABLE IF NOT EXISTS SOPORTES_TECNICOS (\n" +
            "  ID INT NOT NULL AUTO_INCREMENT,\n" +
            "  USUARIO_ID INT NOT NULL,\n" +
            "  EQUIPO_ID INT NOT NULL,\n" +
            "  SERVICIO_ID INT NOT NULL,\n" +
            "  ASUNTO VARCHAR(100) NOT NULL,\n" +
            "  DESCRIPCION LONGTEXT NOT NULL,\n" +
            "  OBSERVACIONES MEDIUMTEXT NOT NULL,\n" +
            "  FECHA DATE NOT NULL,\n" +
            "  PRIMARY KEY (ID));";

    //METODOS
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Música/reporteDeCasosII/src/main/resources/DB/Database","root","toor");
    }
    public static void crearTablas(){
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE_USUARIOS);
            statement.execute(SQL_CREATE_TABLE_EQUIPOS);
            statement.execute(SQL_CREATE_TABLE_SERVICIOS);
            statement.execute(SQL_CREATE_TABLE_SOPORTES_TECNICOS);
            statement.execute(SQL_VERIFY_TABLE_EXISTS);
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
