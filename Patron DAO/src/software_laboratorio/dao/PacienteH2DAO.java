package software_laboratorio.dao;

import org.apache.log4j.Logger;
import software_laboratorio.model.Paciente;

import java.util.List;

public class PacienteH2DAO implements IDao<Paciente>{
    //creamos las variables a utilizar
    private static final Logger LOGGER = Logger.getLogger(PacienteH2DAO.class);
    private static final String SQL_INSERT = "INSERT INTO PACIENTES VALUES(?,?,?,?,?);";
    private static final String SQL_SEARCH = "SELECT * FROM PACIENTES WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET VALUES(?,?,?,?,?);";
    private static final String SQL_DELETE = "DELETE PACIENTES WHERE ID = ?;";
    private static final String SQL_ALLSEARCH = "SELECT * FROM PACIENTES;";

    //METODOS:
    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        return null;
    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
