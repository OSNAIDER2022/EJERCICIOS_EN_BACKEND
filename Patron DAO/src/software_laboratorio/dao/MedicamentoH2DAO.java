package software_laboratorio.dao;

import org.apache.log4j.Logger;
import software_laboratorio.model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoH2DAO implements IDao<Medicamento>{
    //creamos las variables a utilizar
    private static final Logger LOGGER = Logger.getLogger(MedicamentoH2DAO.class);
    private static final String SQL_INSERT = "INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?);";

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        //Preparamos una conexion:
        Connection connection = null;
        try{
            connection = DB.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,medicamento.getId());
            psInsert.setString(3,medicamento.getCodigo());
            psInsert.setString(2,medicamento.getNombre());
            psInsert.setString(4,medicamento.getLaboratorio());
            psInsert.setInt(5,medicamento.getCantidad());
            psInsert.setDouble(6,medicamento.getPrecio());
            psInsert.execute();
            LOGGER.info("Se ha guardado un medicamento");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        return medicamento;


    }
}
