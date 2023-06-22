package com.amsterdam.registro_de_casos.service;

import com.amsterdam.registro_de_casos.dao.IDao;
import com.amsterdam.registro_de_casos.model.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;


public class ServicioService {
    private IDao<Servicio> servicioIDao;

    //CONSTRUCTOR:
    public ServicioService(IDao<Servicio> servicioIDao) {
        this.servicioIDao = servicioIDao;
    }

    //METODOS:
    public Servicio guardarServicio(Servicio servicio){
        return servicioIDao.guardar(servicio);
    }
    public Servicio buscarServicio(Integer id){
        return servicioIDao.buscar(id);
    }
    public void actualizarServicio(Servicio servicio){
        servicioIDao.actualizar(servicio);
    }
    public void eliminarServicio(Integer id){
        servicioIDao.eliminar(id);
    }
    public List<Servicio> buscarTodosLosServicio(){
        return servicioIDao.buscarTodos();
    }
}
