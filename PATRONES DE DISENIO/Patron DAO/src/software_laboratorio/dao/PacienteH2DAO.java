package software_laboratorio.dao;

import org.apache.log4j.Logger;
import software_laboratorio.model.Domicilio;
import software_laboratorio.model.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteH2DAO implements IDao<Paciente>{
    //creamos las variables a utilizar
    private static final Logger LOGGER = Logger.getLogger(PacienteH2DAO.class);
    private static final String SQL_INSERT = "INSERT INTO PACIENTES(NOMBRE, APELLIDO, IDENTIFICACION, FECHA_INGRESO, DOMICILIO_ID) VALUES(?,?,?,?);";
    private static final String SQL_SEARCH = "SELECT * FROM PACIENTES WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET NOMBRE = ?, SET APELLIDO = ?, SET IDENTIFICACION = ?, SET FECHA_INGRESO = ?, SET DOMICILIO = ? WHERE ID = ?;";
    private static final String SQL_DELETE = "DELETE PACIENTES WHERE ID = ?;";
    private static final String SQL_ALLSEARCH = "SELECT * FROM PACIENTES;";

    //METODOS:
    @Override
    public Paciente guardar(Paciente paciente) {
        //Preparamos una conexion:
        Connection connection = null;
        //Domicilio domicilio = null;

        try {
            LOGGER.info("Se ha iniciado el guardado de un PACIENTE");
            connection = DB.getConnection();
            //se inserta "Statement.RETURN_GENERATED_KEYS" para devolver el id recien generado y de este modo mostrar los datos ingresados:
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getIdentificacion());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            psInsert.setObject(5,paciente.getDomicilio());
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
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de GUARDAR PACIENTE. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado el guardado de un PACIENTE exitosamente");

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
               paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getNString(3),rs.getNString(4),rs.getDate(5).toLocalDate(),domicilio);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                LOGGER.warn("ADVERTENCIA: Se ha producido un error en la ejecucion de BUSCAR PACIENTE. Por tanto, se intentará cerrar la conexion con la DB");
                connection.close();
            } catch (SQLException e2) {
                LOGGER.error("ALERTA: Se ha generado un error que ha impedido el cierre de la conexion con la DB");
                e2.printStackTrace();
            }
        }
        LOGGER.info("Se ha finalizado la busqueda de un DOMICILIO exitosamente");
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        //Preparamos una conexion:
        Connection connection = null;

        try {
            LOGGER.info("Se ha iniciado la actualizacion de un PACIENTE");
            connection = DB.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(3, paciente.getIdentificacion());
            psUpdate.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            psUpdate.setObject(5, paciente.getDomicilio());
            psUpdate.setInt(6,paciente.getId());
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

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
