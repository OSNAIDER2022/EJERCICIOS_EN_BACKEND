package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Equipo;
import org.apache.log4j.Logger;

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
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Equipo equipo) {

    }

    @Override
    public Equipo buscar(Integer id) {
        return null;
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return null;
    }
}
