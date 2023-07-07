package com.amsterdam.reporteDeCasosII.service;

import com.amsterdam.reporteDeCasosII.dao.IDao;
import com.amsterdam.reporteDeCasosII.model.SoporteTecnico;

import java.util.List;


public class SoporteTecnicoService {
    private IDao<SoporteTecnico> soporteTecnicoIDao;

    //CONSTRUCTOR:
    public SoporteTecnicoService(IDao<SoporteTecnico> soporteTecnicoIDao) {
        this.soporteTecnicoIDao = soporteTecnicoIDao;
    }

    //METODOS:
    public SoporteTecnico guardarSoporteTecnico(SoporteTecnico soporteTecnico){
        return soporteTecnicoIDao.guardar(soporteTecnico);
    }
    public SoporteTecnico buscarSoporteTecnico(Integer id){
        return soporteTecnicoIDao.buscar(id);
    }
    public void actualizarSoporte(SoporteTecnico soporteTecnico){
        soporteTecnicoIDao.actualizar(soporteTecnico);
    }
    public void eliminarSoporteTecnico(Integer id){
        soporteTecnicoIDao.eliminar(id);
    }
    List<SoporteTecnico> buscarTodosLosSoportesTecnicos(){
        return soporteTecnicoIDao.buscarTodos();
    }
}
