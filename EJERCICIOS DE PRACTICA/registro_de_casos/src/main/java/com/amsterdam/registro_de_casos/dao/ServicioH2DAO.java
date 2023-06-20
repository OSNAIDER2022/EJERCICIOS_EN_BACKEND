package com.amsterdam.registro_de_casos.dao;

import com.amsterdam.registro_de_casos.model.Servicio;
import org.apache.log4j.Logger;

import java.util.List;

public class ServicioH2DAO implements IDao<Servicio>{
    //ESTABLECEMOS CONSTANTES:
    private static final String SQL_ALLSEARCH = "SELECT * FROM servicios;";
    private static final String SQL_DELETE = "DELETE FROM servicios WHERE ID = ?;";
    private static final String SQL_UPDATE = "UPDATE servicios SET nombreDeServicio = ?, SET descripcion = ?, SET precio = ? WHERE ID = ?;";
    private static final String SQL_SEARCH = "SELECT * FROM servicios WHERE ID = ?;";
    private static final String SQL_INSERT = "INSERT INTO servicios (nombreDeServicio, descripcion, precio) VALUES(?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(ServicioH2DAO.class);

    //SOBREESCRITURA DE METODOS:
    @Override
    public List<Servicio> buscarTodos() {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Servicio servicio) {

    }

    @Override
    public Servicio buscar(Integer id) {
        return null;
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        return null;
    }
}
