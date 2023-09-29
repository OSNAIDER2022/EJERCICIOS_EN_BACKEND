package com.amsterdam.reporteDeCasosII.dao;

import com.amsterdam.reporteDeCasosII.model.Equipo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EquipoH2DAO implements IDao<Equipo>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM EQUIPOS;";
    private static final String SQL_DELETE = " DELETE FROM EQUIPOS WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE EQUIPOS SET MODELO = ?, SERIAL = ?  WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM EQUIPOS WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO EQUIPOS (MODELO, SERIAL) VALUES(?,?);";
    private static final Logger LOGGER = Logger.getLogger(EquipoH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Equipo> buscarTodos() {
        Connection connection = null;
        Equipo equipo = null;
        List<Equipo> equipos = new ArrayList<>();

        try{
            LOGGER.info("Se ha iniciado la busqueda de todos los EQUIPOS de la Database");
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            while (rs.next()){
                equipo = new Equipo(rs.getInt(1),rs.getNString(2),rs.getNString(3));
                equipos.add(equipo);
                LOGGER.info("SE ha de mostrar el EQUIPO de serial:" + equipo.getSerial());
            }
            LOGGER.info("Se ha finalizado la busqueda de todos los EQUIPOS de la Database");

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return equipos;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        Equipo equipo = null;

        try{
            LOGGER.warn("Se ha comenzado la eliminacion del EQUIPO con el ID: " + id);
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
    public void actualizar(Equipo equipo) {
        Connection connection = null;
        try {
            LOGGER.info("Se ha comenzado la actualizacion de datos para el EQUIPO con el ID: " + equipo.getId());
            connection = Database.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,equipo.getModelo());
            psUpdate.setString(2,equipo.getSerial());
            psUpdate.setInt(3,equipo.getId());
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
    public Equipo buscar(Integer id) {
        Connection connection = null;
        Equipo equipo = null;

        try {
            LOGGER.info("Se ha comenzado la busqueda de un EQUIPO con el ID: " + id);
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                equipo = new Equipo(rs.getInt(1),rs.getNString(2),rs.getNString(3));
                LOGGER.info("Se ha encontrado la busqueda para el EQUIPO con el ID: " + id + " bajo el serial: " + equipo.getSerial());
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return equipo;
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        Connection connection = null;

        try {
            LOGGER.info("Se ha comenzado el proceso de guardado de datos para un equipo.");
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,equipo.getModelo());
            psInsert.setString(2,equipo.getSerial());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                equipo.setId(rs.getInt(1));
                LOGGER.info("Se ha generado el ID: "+ equipo.getId() +" para el equipo a ingresar.");
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return equipo;
    }
}
