package software_laboratorio.service;

import software_laboratorio.dao.IDao;
import software_laboratorio.model.Paciente;

import java.util.List;

public class PacienteService {
    //ATRIBUTOS:
    private IDao<Paciente> pacienteIDao;

    //CONSTRUCTOR:
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
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
    public List<Paciente> buscarTodosLosPacientes(){
        return pacienteIDao.buscarTodos();
    }



}
