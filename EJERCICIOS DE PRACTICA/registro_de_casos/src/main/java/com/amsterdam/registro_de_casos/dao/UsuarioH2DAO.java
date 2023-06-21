package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Usuario;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioH2DAO implements IDao<Usuario>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM usuarios;";
    private static final String SQL_DELETE = "DELETE FROM WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombreCompleto = ?, SET numeroCelular = ?, SET correo = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM usuarios WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO usuarios (nombreCompleto, numeroCelular, correo) VALUES(?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(UsuarioH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Usuario> buscarTodos() {
        Connection connection = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try{
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);

            ResultSet rs = psSearchAll.executeQuery();
            while(rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getNString(2), rs.getNString(3),rs.getNString(4));
                usuarios.add(usuario);
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return usuarios;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        Usuario usuario = null;
        try {
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, usuario.getId());
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
    public void actualizar(Usuario usuario) {
        Connection connection = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,usuario.getNombreCompleto());
            psUpdate.setString(2,usuario.getNumeroCelular());
            psUpdate.setString(3,usuario.getCorreo());
            psUpdate.setInt(4,usuario.getId());
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
    public Usuario buscar(Integer id) {
        Connection connection = null;
        Usuario usuario = null;

        try{
            LOGGER.info("Se ha comenzado la busqueda de un usuario" + usuario.getId());
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,usuario.getId());
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getNString(2),rs.getString(3),rs.getString(4));
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
        return usuario;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        Connection connection = null;
        try{
            LOGGER.info("Se ha iniciado el guardado del USUARIO con ID: " + usuario.getId());
            connection = Database.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,usuario.getNombreCompleto());
            psInsert.setString(2,usuario.getNumeroCelular());
            psInsert.setString(3,usuario.getCorreo());
            psInsert.execute();

            ResultSet rs =psInsert.getGeneratedKeys();
            while (rs.next()){
                usuario.setId(rs.getInt(1));
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return usuario;
    }
}