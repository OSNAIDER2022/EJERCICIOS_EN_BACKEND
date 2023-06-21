package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Equipo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoH2DAO implements IDao<Equipo>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM equipos;";
    private static final String SQL_DELETE = " DELETE FROM equipos WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE equipos SET modelo = ?, SET serial = ?  WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM equipos WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO equipos(modelo, serial) VALUES(?,?);";
    private static final Logger LOGGER = Logger.getLogger(EquipoH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Equipo> buscarTodos() {
        Connection connection = null;
        Equipo equipo = null;
        List<Equipo> equipos = new ArrayList<>();

        try{
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            while (rs.next()){
                equipo = new Equipo(rs.getInt(1),rs.getNString(2),rs.getNString(3));
                equipos.add(equipo);
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
        return equipos;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        try{
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
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                equipo = new Equipo(rs.getInt(1),rs.getNString(2),rs.getNString(3));
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
        return equipo;
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        Connection connection = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,equipo.getModelo());
            psInsert.setString(2,equipo.getSerial());
            psInsert.setInt(3,equipo.getId());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                equipo.setId(rs.getInt(1));
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
        return equipo;
    }
}
