package software_laboratorio;

import software_laboratorio.dao.DB;
import software_laboratorio.dao.MedicamentoH2DAO;
import software_laboratorio.model.Medicamento;
import software_laboratorio.service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //primero: Se crean las tablas
        DB.crearTabla();
        //segundo: Se prepara un medicamento a guardar
        Medicamento medicamento = new Medicamento(1,"H36SG22","AMOXICILINA","GENFAR",30,34.0);
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoH2DAO());
        //tercero: Guardamos el medicamento
        medicamentoService.guardarMedicamento(medicamento);
    }
}
