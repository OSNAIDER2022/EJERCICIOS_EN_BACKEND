package com.amsterdam.reporteDeCasosII.dao;

import com.amsterdam.reporteDeCasosII.model.Equipo;
import com.amsterdam.reporteDeCasosII.model.Servicio;
import com.amsterdam.reporteDeCasosII.model.SoporteTecnico;
import com.amsterdam.reporteDeCasosII.model.Usuario;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SoporteTecnicoH2DAO implements IDao<SoporteTecnico>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM SOPORTES_TECNICOS;";
    private static final String SQL_DELETE = "DELETE FROM SOPORTES_TECNICOS WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE SOPORTES_TECNICOS SET USUARIO_ID = ?, EQUIPO_ID = ?, SERVICIO_ID = ?, ASUNTO = ?, DESCRIPCION = ?, OBSERVACIONES = ?, FECHA = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM SOPORTES_TECNICOS WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO SOPORTES_TECNICOS (USUARIO_ID, EQUIPO_ID, SERVICIO_ID, ASUNTO, DESCRIPCION, OBSERVACIONES, FECHA) VALUES(?,?,?,?,?,?,?);";
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
            LOGGER.info("Se ha iniciado la busqueda de todos los SOPORTES TECNICOS de la Database");
            connection = Database.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
            ResultSet rs = psSearchAll.executeQuery();

            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();


            while (rs.next()){
                usuario = usuarioH2DAO.buscar(rs.getInt(2));
                equipo = equipoH2DAO.buscar(rs.getInt(3));
                servicio = servicioH2DAO.buscar(rs.getInt(4));

                soporteTecnico = new SoporteTecnico(rs.getInt(1),usuario,equipo,servicio,rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate());
                soportesTecnicos.add(soporteTecnico);
                LOGGER.info("SE ha de mostrar el SOPORTE TECNICO:" + soporteTecnico.getId());
            }
            LOGGER.info("Se ha finalizado la busqueda de todos los SOPORTES TECNICOS de la Database");

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return soportesTecnicos;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;

        try {
            LOGGER.warn("Se ha comenzado la eliminacion del SOPORTE TECNICO con el ID: " + id);
            connection = Database.getConnection();
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
    public void actualizar(SoporteTecnico soporteTecnico) {
        Connection connection = null;

        try {
            LOGGER.info("Se ha comenzado la actualizacion de datos para el SOPORTE TECNICO con el ID: " + soporteTecnico.getId());
            connection = Database.getConnection();

            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();

            usuarioH2DAO.actualizar(soporteTecnico.getUsuario());
            equipoH2DAO.actualizar(soporteTecnico.getEquipo());
            servicioH2DAO.actualizar(soporteTecnico.getServicio());

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
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
            }catch (Exception e2){
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
            LOGGER.info("Se ha comenzado la busqueda de un SOPORTE TECNICO con el ID: " + id);
            connection = Database.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1,id);

            ResultSet rs = psSearch.executeQuery();

            UsuarioH2DAO usuarioH2DAO = new UsuarioH2DAO();
            ServicioH2DAO servicioH2DAO = new ServicioH2DAO();
            EquipoH2DAO equipoH2DAO = new EquipoH2DAO();


            while (rs.next()){
                usuario = usuarioH2DAO.buscar(rs.getInt(2));
                equipo = equipoH2DAO.buscar(rs.getInt(3));
                servicio = servicioH2DAO.buscar(rs.getInt(4));

                soporteTecnico = new SoporteTecnico(rs.getInt(1),usuario,equipo,servicio,rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate());
                LOGGER.info("Se ha encontrado la busqueda para el usuario con el ID: " + id + " bajo el ASUNTO de: " + soporteTecnico.getAsunto());
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
        return soporteTecnico;
    }

    @Override
    public SoporteTecnico guardar(SoporteTecnico soporteTecnico) {
        Connection connection = null;

        try {
            LOGGER.info("Se ha iniciado el guardado del SOPORTE TECNICO de asunto: " + soporteTecnico.getAsunto());
            connection = Database.getConnection();
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
                LOGGER.info("Se ha generado el ID: " + soporteTecnico.getId() + " para el SOPORTE TECNICO de asunto: " + soporteTecnico.getAsunto());
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
        return soporteTecnico;
    }
}
