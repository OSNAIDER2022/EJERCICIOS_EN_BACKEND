package software_laboratorio.service;

import software_laboratorio.dao.IDao;
import software_laboratorio.model.Medicamento;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;

    //CONSTRUCTOR
    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }
    //METODOS:
    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    }
}
