package com.amsterdam.reporteDeCasosII.service;

import com.amsterdam.reporteDeCasosII.dao.IDao;
import com.amsterdam.reporteDeCasosII.model.Servicio;

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
