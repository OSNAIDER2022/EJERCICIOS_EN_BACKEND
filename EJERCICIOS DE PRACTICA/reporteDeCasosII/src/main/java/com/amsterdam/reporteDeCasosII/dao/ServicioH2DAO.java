package com.amsterdam.reporteDeCasosII.dao;

import com.amsterdam.reporteDeCasosII.model.Servicio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioH2DAO implements IDao<Servicio>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM SERVICIOS;";
    private static final String SQL_DELETE = "DELETE FROM SERVICIOS WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE SERVICIOS SET NOMBRE_DE_SERVICIO = ?, DESCRIPCION = ?, PRECIO = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM SERVICIOS WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO SERVICIOS (NOMBRE_DE_SERVICIO, DESCRIPCION, PRECIO) VALUES(?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(ServicioH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Servicio> buscarTodos() {
        Connection connection = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList<>();

        try {
            LOGGER.info("Se ha iniciado la busqueda de todos los SERVICIOS de la Database");
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            while (rs.next()){
                servicio = new Servicio(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getDouble(4));
                servicios.add(servicio);
                LOGGER.info("SE ha de mostrar el EQUIPO de serial:" + servicio.getNombreDeServicio());
            }
            LOGGER.info("Se ha finalizado la busqueda de todos los SERVICIOS de la Database");
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return servicios;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        Servicio servicio = null;

        try {
            LOGGER.warn("Se ha comenzado la eliminacion del SERVICIO con el ID: " + id);
            connection = Database.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1,id);
            psDelete.execute();

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void actualizar(Servicio servicio) {
        Connection connection = null;

        try{
            LOGGER.info("Se ha comenzado la actualizacion de datos para el SERVICIO con el ID: " + servicio.getId());
            connection = Database.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,servicio.getNombreDeServicio());
            psUpdate.setString(2,servicio.getDescripcion());
            psUpdate.setDouble(3,servicio.getPrecio());
            psUpdate.setInt(4,servicio.getId());
            psUpdate.execute();


        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Servicio buscar(Integer id) {
        Connection connection = null;
        Servicio servicio = null;

        try {
            LOGGER.info("Se ha comenzado la busqueda de un SERVICIO con el ID: " + id);
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1, id);
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                servicio = new Servicio(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                LOGGER.info("Se ha encontrado la busqueda para el SERVICIO con el ID: " + id + " bajo el nombre de: " + servicio.getNombreDeServicio());
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return servicio;
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        Connection connection = null;

        try {
            LOGGER.info("Se ha comenzado el proceso de guardado de datos para un servicio.");
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,servicio.getNombreDeServicio());
            psInsert.setString(2,servicio.getDescripcion());
            psInsert.setDouble(3,servicio.getPrecio());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                servicio.setId(rs.getInt(1));
                LOGGER.info("Se ha generado el ID: "+ servicio.getId() +" para el servicio a ingresar.");
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return servicio;
    }
}
