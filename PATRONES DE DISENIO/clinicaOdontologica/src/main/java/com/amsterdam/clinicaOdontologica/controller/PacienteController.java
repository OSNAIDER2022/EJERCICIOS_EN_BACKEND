package com.amsterdam.clinicaOdontologica.controller;

import com.amsterdam.clinicaOdontologica.model.Paciente;
import com.amsterdam.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    //CONSTRUCTOR:
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //METODOS:
    @GetMapping
    public String buscarPacientePorCorreo(Model model, @RequestParam("email")String email){
        Paciente paciente = pacienteService.buscarPorCorreo(email);
        model.addAttribute("nombreAMostrar", paciente.getNombre());
        model.addAttribute("apellidoAMostrar", paciente.getApellido());
        //devolvemos el template html
        return "index";
    }


    @PostMapping
    //mediante @RequestBody capturamos el .json que viene con la informacion de paciente para ser usado
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        //Se estabece una condicional para validar la existencia del paciente dentro de la DB
        Paciente pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());

        if (pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "Se ha actualizado el paciente con el id = " + paciente.getId() + " de forma exitosa";
        }else{
            return "El paciente con el id = " + paciente.getId() + " no existe en la DB";
        }
    }

}
