package com.amsterdam.clinicaOdontologica.dao;

import org.apache.log4j.Logger;
import com.amsterdam.clinicaOdontologica.model.Domicilio;
import com.amsterdam.clinicaOdontologica.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteH2DAO implements IDao<Paciente> {
    //creamos las variables a utilizar
    private static final Logger LOGGER = Logger.getLogger(PacienteH2DAO.class);
    private static final String SQL_INSERT = "INSERT INTO PACIENTES(NOMBRE, APELLIDO, IDENTIFICACION, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES(?,?,?,?,?,?);";
    private static final String SQL_SEARCH = "SELECT * FROM PACIENTES WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET NOMBRE = ?, SET APELLIDO = ?, SET IDENTIFICACION = ?, SET FECHA_INGRESO = ?, SET DOMICILIO_ID = ?, SET EMAIL = ? WHERE ID = ?;";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID = ?;";
    private static final String SQL_ALLSEARCH = "SELECT * FROM PACIENTES;";
    private static final String SQL_SEARCHBYEMAIL = "SELECT * FROM PACIENTES WHERE EMAIL = ?;";

    //METODOS:
    @Override
    public Paciente guardar(Paciente paciente) {
        //Preparamos una conexion:
        Connection connection = null;

        try {
            LOGGER.info("Se ha iniciado el guardado de un PACIENTE");
            connection = DB.getConnection();
            //relizamos un DomicilioH2DAO para ingresar datos por foreign key
            DomicilioH2DAO domicilioH2DAO = new DomicilioH2DAO();
            Domicilio nuevoDomicilio = domicilioH2DAO.guardar(paciente.getDomicilio());
            //se inserta "Statement.RETURN_GENERATED_KEYS" para devolver el id recien generado y de este modo mostrar los datos ingresados:
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getIdentificacion());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            psInsert.setInt(5, nuevoDomicilio.getId());
            psInsert.setString(6,paciente.getEmail());
            psInsert.execute();

            //con esto devolvemos el ID generado:
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        //Preparamos una conexion:
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;

        try {
            LOGGER.info("Se ha iniciado la busqueda de un PACIENTE");
            connection = DB.getConnection();
            PreparedStatement psSearch = connection.prepareStatement(SQL_SEARCH);
            psSearch.setInt(1, id);
            ResultSet rs = psSearch.executeQuery();

            DomicilioH2DAO domicilioH2DAO = new DomicilioH2DAO();
            domicilio = domicilioH2DAO.buscar(rs.getInt(6));

            while (rs.next()) {
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5).toLocalDate(), domicilio, rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        //Preparamos una conexion:
        Connection connection = null;

        try {
            LOGGER.info("Se ha iniciado la actualizacion de un PACIENTE");
            connection = DB.getConnection();
            //relizamos un DomicilioH2DAO para ingresar datos por foreign key
            DomicilioH2DAO domicilioH2DAO = new DomicilioH2DAO();
            domicilioH2DAO.actualizar(paciente.getDomicilio());
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(3, paciente.getIdentificacion());
            psUpdate.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            psUpdate.setObject(5, paciente.getDomicilio().getId());
            psUpdate.setString(6,paciente.getEmail());
            psUpdate.setInt(7, paciente.getId());
            psUpdate.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        //Preparamos una conexion:
        Connection connection = null;
        Paciente paciente = null;

        try {
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
}

    @Override
    public List<Paciente> buscarTodos() {
            //Preparamos una conexion:
            Connection connection = null;
            Paciente paciente = null;
            Domicilio domicilio = null;
            List<Paciente> pacientes = new ArrayList<>();

            try {
                connection = DB.getConnection();
                PreparedStatement psSearchAll = connection.prepareStatement(SQL_ALLSEARCH);
                ResultSet rs = psSearchAll.executeQuery();

                DomicilioH2DAO domicilioH2DAO = new DomicilioH2DAO();
                domicilio = domicilioH2DAO.buscar(rs.getInt(6));

                while (rs.next()) {
                    paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5).toLocalDate(), domicilio, rs.getString(7));
                    pacientes.add(paciente);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            return pacientes;
    }


    @Override
    public Paciente buscarPorString(String valor) {
        //Preparamos una conexion:
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;

        try {
            LOGGER.info("Se ha iniciado la busqueda de un PACIENTE por EMAIL");
            connection = DB.getConnection();
            PreparedStatement psSearchByEmail = connection.prepareStatement(SQL_SEARCHBYEMAIL);
            psSearchByEmail.setString(1, valor);
            ResultSet rs = psSearchByEmail.executeQuery();

            DomicilioH2DAO domicilioH2DAO = new DomicilioH2DAO();

            while (rs.next()) {
                domicilio = domicilioH2DAO.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getNString(3), rs.getNString(4), rs.getDate(5).toLocalDate(), domicilio, rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de BUSCAR PACIENTE POR EMAIL. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado la busqueda de un BUSCAR PACIENTE POR EMAIL exitosamente");
        return paciente;
    }

}