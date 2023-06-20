package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.SoporteTecnico;
import org.apache.log4j.Logger;

import java.util.List;

public class SoporteTecnicoH2DAO implements IDao<SoporteTecnico>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM soportesTecnicos;";
    private static final String SQL_DELETE = "DELETE FROM soportesTecnicos WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE soportesTecnicos SET fecha = ?, SET asunto = ?, SET descripcion = ?, SET observaciones = ?, SET usuario_id = ?, SET servicio_id = ?, SET equipo_id = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM soportesTecnicos WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO soportesTecnicos (fecha, asunto, descripcion, observaciones, usuario_id, servicio_id, equipo_id) VALUES(?,?,?,?,?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(SoporteTecnicoH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<SoporteTecnico> buscarTodos() {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(SoporteTecnico soporteTecnico) {

    }

    @Override
    public SoporteTecnico buscar(Integer id) {
        return null;
    }

    @Override
    public SoporteTecnico guardar(SoporteTecnico soporteTecnico) {
        return null;
    }
}
