package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Servicio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioH2DAO implements IDao<Servicio>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM servicios;";
    private static final String SQL_DELETE = "DELETE FROM servicios WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE servicios SET nombreDeServicio = ?, SET descripcion = ?, SET precio = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM servicios WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO servicios (nombreDeServicio, descripcion, precio) VALUES(?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(ServicioH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Servicio> buscarTodos() {
        Connection connection = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList<>();

        try {
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            while (rs.next()){
                servicio = new Servicio(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getDouble(4));
                servicios.add(servicio);
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
        return servicios;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        Servicio servicio = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1,servicio.getId());
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
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1, servicio.getId());
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                servicio = new Servicio(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
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
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,servicio.getNombreDeServicio());
            psInsert.setString(2,servicio.getDescripcion());
            psInsert.setDouble(3,servicio.getPrecio());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                servicio.setId(rs.getInt(1));
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
