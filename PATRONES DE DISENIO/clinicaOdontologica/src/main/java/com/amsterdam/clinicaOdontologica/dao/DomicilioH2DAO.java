package com.amsterdam.clinicaOdontologica.dao;

import org.apache.log4j.Logger;
import com.amsterdam.clinicaOdontologica.model.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioH2DAO implements IDao<Domicilio> {
    //creamos las variables a utilizar
    private static final Logger LOGGER = Logger.getLogger(DomicilioH2DAO.class);
    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?);";
    private static final String SQL_SEARCH = "SELECT * FROM DOMICILIOS WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE DOMICILIOS SET CALLE = ?, SET NUMERO = ?, SET LOCALIDAD = ?, SET PROVINCIA = ? WHERE ID = ?;";
    private static final String SQL_DELETE = "DELETE FROM DOMICILIOS WHERE ID = ?;";
    private static final String SQL_ALLSEARCH = "SELECT * FROM DOMICILIOS;";

    //METODOS:
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        //Preparamos una conexion:
        Connection connection = null;
        try {
            LOGGER.info("Se ha iniciado el guardado de un DOMICILIO");
            connection = DB.getConnection();
            //se inserta "Statement.RETURN_GENERATED_KEYS" para devolver el id recien generado y de este modo mostrar los datos ingresados:
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setString(2, domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();

            //con esto devolvemos el ID generado:
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de GUARDAR DOMICILIO. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado el guardado de un DOMICILIO exitosamente");
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        //Preparamos una conexion:
        Connection connection = null;
        //debido a que se debe realizar la declaracion de un objeto tipo DOMICILIO se debe declarar el objeto con el valor NULL. Esto nos permitirá hacer uso del RESULSET para retornar un domicilio:
        Domicilio domicilio = null;
        try {
            LOGGER.info("Se ha iniciado la busqueda de un DOMICILIO");
            connection = DB.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1, id);
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de BUSCAR DOMICILIO. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado la busqueda de un DOMICILIO exitosamente");
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        //Preparamos una conexion:
        Connection connection = null;

        try {
            LOGGER.info("Se ha iniciado la actualizacion de un DOMICILIO");
            connection = DB.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, domicilio.getCalle());
            psUpdate.setString(2, domicilio.getNumero());
            psUpdate.setString(3, domicilio.getLocalidad());
            psUpdate.setString(4, domicilio.getProvincia());
            psUpdate.setInt(5, domicilio.getId());
            psUpdate.execute();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de ACTUALIZAR DOMICILIO. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado la actualizacion de un DOMICILIO exitosamente");
    }

    @Override
    public void eliminar(Integer id) {
        //Preparamos una conexion:
        Connection connection = null;
        //debido a que se debe realizar la declaracion de un objeto tipo DOMICILIO se debe declarar el objeto con el valor NULL. Esto nos permitirá hacer uso del RESULSET para retornar un domicilio:
        Domicilio domicilio = null;
        try {
            LOGGER.info("Se ha iniciado la eliminacion de un DOMICILIO");
            connection = DB.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de ELIMINAR DOMICILIO. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado la eliminacion de un DOMICILIO exitosamente");

    }

    @Override
    public List<Domicilio> buscarTodos() { return null; }

    @Override
    public Domicilio buscarPorString(String valor) {
        return null;
    }
}
