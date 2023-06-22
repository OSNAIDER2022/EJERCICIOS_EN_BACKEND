package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Equipo;
import com.amsterdam.registro_de_casos.model.Servicio;
import com.amsterdam.registro_de_casos.model.SoporteTecnico;
import com.amsterdam.registro_de_casos.model.Usuario;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoporteTecnicoH2DAO implements IDao<SoporteTecnico>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM soportesTecnicos;";
    private static final String SQL_DELETE = "DELETE FROM soportesTecnicos WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE soportesTecnicos SET usuario_id = ?, SET equipo_id = ?, SET servicio_id = ?, SET asunto = ?, SET descripcion = ?, SET observaciones = ?, SET fecha = ? WHERE id = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM soportesTecnicos WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO soportesTecnicos (usuario_id, equipo_id, servicio_id, asunto, descripcion, observaciones, fecha) VALUES(?,?,?,?,?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(SoporteTecnicoH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<SoporteTecnico> buscarTodos() {
        Connection connection = null;
        Usuario usuario = null;
        Equipo equipo = null;
        Servicio servicio = null;
        SoporteTecnico soporteTecnico = null;
        List<SoporteTecnico> soportesTecnicos = new ArrayList<>();

        try {
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_SEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            usuario = usuarioH2DAO.buscar(rs.getInt(2));
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            servicio = servicioH2DAO.buscar(rs.getInt(3));
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();
            equipo = equipoH2DAO.buscar(rs.getInt(4));

            while (rs.next()){
                soporteTecnico = new SoporteTecnico(rs.getInt(1),usuario,equipo,servicio,rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate());
                soportesTecnicos.add(soporteTecnico);
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

        return soportesTecnicos;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        SoporteTecnico soporteTecnico = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, soporteTecnico.getId());
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
    public void actualizar(SoporteTecnico soporteTecnico) {
        Connection connection = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            usuarioH2DAO.actualizar(soporteTecnico.getUsuario());
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();
            equipoH2DAO.actualizar(soporteTecnico.getEquipo());
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            servicioH2DAO.actualizar(soporteTecnico.getServicio());

            psUpdate.setInt(1,soporteTecnico.getUsuario().getId());
            psUpdate.setInt(2,soporteTecnico.getEquipo().getId());
            psUpdate.setInt(3,soporteTecnico.getEquipo().getId());
            psUpdate.setString(5,soporteTecnico.getDescripcion());
            psUpdate.setString(4,soporteTecnico.getAsunto());
            psUpdate.setString(6,soporteTecnico.getObservaciones());
            psUpdate.setDate(7, Date.valueOf(soporteTecnico.getFecha()));
            psUpdate.setInt(8,soporteTecnico.getId());
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
    public SoporteTecnico buscar(Integer id) {
        Connection connection = null;
        SoporteTecnico soporteTecnico = null;
        Usuario usuario = null;
        Equipo equipo = null;
        Servicio servicio = null;

        try {
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);
            ResultSet rs = psSearch.executeQuery();

            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            usuario = usuarioH2DAO.buscar(rs.getInt(2));
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            servicio = servicioH2DAO.buscar(rs.getInt(3));
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();
            equipo = equipoH2DAO.buscar(rs.getInt(4));

            while (rs.next()){
                soporteTecnico = new SoporteTecnico(rs.getInt(1),usuario,equipo,servicio,rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate());
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
        return soporteTecnico;
    }

    @Override
    public SoporteTecnico guardar(SoporteTecnico soporteTecnico) {
        Connection connection = null;

        try {
            connection = Database.getConnection();
            //ingreso de datos por FOREIGN KEY
            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            Usuario usuario_id = usuarioH2DAO.guardar(soporteTecnico.getUsuario());
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();
            Equipo equipo_id = equipoH2DAO.guardar(soporteTecnico.getEquipo());
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            Servicio servicio_id = servicioH2DAO.guardar(soporteTecnico.getServicio());

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1,usuario_id.getId());
            psInsert.setInt(2,equipo_id.getId());
            psInsert.setInt(3,servicio_id.getId());
            psInsert.setString(4,soporteTecnico.getAsunto());
            psInsert.setString(5,soporteTecnico.getDescripcion());
            psInsert.setString(6,soporteTecnico.getObservaciones());
            psInsert.setDate(7, Date.valueOf(soporteTecnico.getFecha()));
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                soporteTecnico.setId(rs.getInt(1));
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
        return soporteTecnico;
    }
}
