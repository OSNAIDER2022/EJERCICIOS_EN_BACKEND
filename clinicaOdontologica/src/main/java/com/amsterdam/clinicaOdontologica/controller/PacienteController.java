package com.amsterdam.clinicaOdontologica.controller;

import com.amsterdam.clinicaOdontologica.model.Paciente;
import com.amsterdam.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    //CONSTRUCTOR:
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //METODOS:
    @GetMapping
    public String BuscarPacientePorCorreo(Model model, @RequestParam("emailAConsultar") String emailAConsultar){
        Paciente paciente = pacienteService.buscarPorCorreo(emailAConsultar);
        model.addAttribute("nombreAMostrar", paciente.getNombre());
        model.addAttribute("apellidoAMostrar", paciente.getApellido());
        //devolvemos el template html
        return "index";
    }

}
