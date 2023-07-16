package com.amsterdam.reporteDeCasosII.service;

import com.amsterdam.reporteDeCasosII.dao.IDao;
import com.amsterdam.reporteDeCasosII.dao.SoporteTecnicoH2DAO;
import com.amsterdam.reporteDeCasosII.model.SoporteTecnico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoporteTecnicoService {
    private IDao<SoporteTecnico> soporteTecnicoIDao;

    //CONSTRUCTOR:
    public SoporteTecnicoService() {
        soporteTecnicoIDao = new SoporteTecnicoH2DAO();
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
    public List<SoporteTecnico> buscarTodosLosSoportesTecnicos(){
        return soporteTecnicoIDao.buscarTodos();
    }
}
