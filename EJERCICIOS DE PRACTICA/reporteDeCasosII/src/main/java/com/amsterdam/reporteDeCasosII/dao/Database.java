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
    /*
    private static final String SQL_CREATE_TABLE_SOPORTES_TECNICOS = "CREATE TABLE IF NOT EXISTS `Databases`.`soportesTecnicos` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `usuarios_id` INT NOT NULL,\n" +
            "  `equipos_id` INT NOT NULL,\n" +
            "  `servicios_id` INT NOT NULL,\n" +
            "  `asunto` VARCHAR(100) NOT NULL,\n" +
            "  `descripcion` LONGTEXT NOT NULL,\n" +
            "  `observaciones` MEDIUMTEXT NOT NULL,\n" +
            "  `fecha` DATE NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_soportesTecnicos_usuarios_idx` (`usuarios_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_soportesTecnicos_equipos1_idx` (`equipos_id` ASC) VISIBLE,\n" +
            "  INDEX `fk_soportesTecnicos_servicios1_idx` (`servicios_id` ASC) VISIBLE,\n" +
            "  CONSTRAINT `fk_soportesTecnicos_usuarios`\n" +
            "    FOREIGN KEY (`usuarios_id`)\n" +
            "    REFERENCES `mydb`.`usuarios` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_soportesTecnicos_equipos1`\n" +
            "    FOREIGN KEY (`equipos_id`)\n" +
            "    REFERENCES `mydb`.`equipos` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_soportesTecnicos_servicios1`\n" +
            "    FOREIGN KEY (`servicios_id`)\n" +
            "    REFERENCES `mydb`.`servicios` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;"+
            "\n" +
            "SET SQL_MODE=@OLD_SQL_MODE;\n" +
            "SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;\n" +
            "SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;\n";
*/
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
//            statement.execute(SQL_CREATE_TABLE_SERVICIOS);
//            statement.execute(SQL_CREATE_TABLE_SOPORTES_TECNICOS);

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
