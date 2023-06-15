package com.amsterdam.clinicaOdontologica.service;

import com.amsterdam.clinicaOdontologica.dao.IDao;
import com.amsterdam.clinicaOdontologica.dao.PacienteH2DAO;
import com.amsterdam.clinicaOdontologica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    //ATRIBUTOS:
    private IDao<Paciente> pacienteIDao;

    //CONSTRUCTOR:
    public PacienteService() {
        this.pacienteIDao = new PacienteH2DAO();
    }

    //METODOS:
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteIDao.guardar(paciente);
    }
    public Paciente buscarPaciente(Integer id){
        return pacienteIDao.buscar(id);
    }
    public void actualizarPaciente(Paciente paciente){
        pacienteIDao.actualizar(paciente);
    }
    public void eliminarPaciente(Integer id){
        pacienteIDao.eliminar(id);
    }
    public List<Paciente> buscarTodosLosPacientes(){ return pacienteIDao.buscarTodos(); }
    public Paciente buscarPorCorreo(String email){
        return pacienteIDao.buscarPorString(email);
    }

}
