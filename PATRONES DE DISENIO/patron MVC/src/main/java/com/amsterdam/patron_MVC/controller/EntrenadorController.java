package com.amsterdam.patron_MVC.controller;

import com.amsterdam.patron_MVC.model.Entrenador;
import com.amsterdam.patron_MVC.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller ==> cuando la aplicacion tiene tecnologia de vista
//@RestController ==> cuando la aplicacion NO tiene tecnologia de vista; aplicada en API's
//AMBAS PUEDEN COEXISTIR EN UN MISMO PROYECTO

@RestController
//Con @RequestMapping mapeamos los endpoints
@RequestMapping("/entrenador")
public class EntrenadorController {
    //ATRIBUTO:
    private EntrenadorService entrenadorService;

    //CONSTRUCTOR:
    //Con @Autowired puedes hacer inyeccion de dependencias
    @Autowired
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    //METODOS:
    //hace match con el metodo GET. PD:Sólo puede haber un @GetMapping por @RequestMapping
    @GetMapping
    public List<Entrenador> obtenerLista(){
        return entrenadorService.obtenerListaDeEntrenadores();
    }
}
