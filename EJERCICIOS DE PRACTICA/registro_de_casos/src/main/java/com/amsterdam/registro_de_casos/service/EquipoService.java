package com.amsterdam.registro_de_casos.service;

import com.amsterdam.registro_de_casos.dao.IDao;
import com.amsterdam.registro_de_casos.model.Equipo;
import org.springframework.stereotype.Service;

import java.util.List;


public class EquipoService {
    private IDao<Equipo> equipoIDao;

    //CONTRUCTOR:
    public EquipoService(IDao<Equipo> equipoIDao) {
        this.equipoIDao = equipoIDao;
    }

    //METODOS:
    public Equipo guardarEquipo(Equipo equipo){
        return equipoIDao.guardar(equipo);
    }
    public Equipo buscarEquipo(Integer id){
        return equipoIDao.buscar(id);
    }
    public void actualizarEquipo(Equipo equipo){
        equipoIDao.actualizar(equipo);
    }
    public void eliminarEquipo(Integer id){
        equipoIDao.eliminar(id);
    }
    public List<Equipo> buscarTodosLosEquipos(){
        return equipoIDao.buscarTodos();
    }
}
