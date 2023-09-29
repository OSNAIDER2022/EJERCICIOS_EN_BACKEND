package com.amsterdam.reporteDeCasosII.dao;

import com.amsterdam.reporteDeCasosII.model.Usuario;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UsuarioH2DAO implements IDao<Usuario>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM USUARIOS;";
    private static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE USUARIOS SET NOMBRE_COMPLETO = ?, NUMERO_CELULAR = ?, CORREO = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM USUARIOS WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO USUARIOS (NOMBRE_COMPLETO, NUMERO_CELULAR, CORREO) VALUES (?,?,?)";
    private static final Logger LOGGER = Logger.getLogger(UsuarioH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Usuario> buscarTodos() {
        Connection connection = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try{
            LOGGER.info("Se ha iniciado la busqueda de todos los USUARIOS de la Database");
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();
            while(rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
                usuarios.add(usuario);
                LOGGER.info("SE ha de mostrar el USUARIO:" + usuario.getNombreCompleto());
            }
            LOGGER.info("Se ha finalizado la busqueda de todos los USUARIOS de la Database");

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return usuarios;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;

        try {
            LOGGER.warn("Se ha comenzado la eliminacion del USUARIO con el ID: " + id);
            connection=Database.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        Connection connection = null;

        try {
            LOGGER.info("Se ha comenzado la actualizacion de datos para el USUARIO con el ID: " + usuario.getId());
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
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Usuario buscar(Integer id) {
        Connection connection = null;
        Usuario usuario = null;

        try{
            LOGGER.info("Se ha comenzado la busqueda de un USUARIO con el ID: " + id);
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);
            ResultSet rs = psSearch.executeQuery();

            while (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                LOGGER.info("Se ha encontrado la busqueda para el usuario con el ID: " + id + " bajo el nombre de: " + usuario.getNombreCompleto());
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
        return usuario;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        Connection connection = null;

        try{
            LOGGER.info("Se ha iniciado el guardado del USUARIO: " + usuario.getNombreCompleto());
            connection = Database.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,usuario.getNombreCompleto());
            psInsert.setString(2,usuario.getNumeroCelular());
            psInsert.setString(3,usuario.getCorreo());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                usuario.setId(rs.getInt(1));
                LOGGER.info("Se ha generado el ID: " + usuario.getId() + " para el USUARIO: " + usuario.getNombreCompleto());
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return usuario;
    }
}
