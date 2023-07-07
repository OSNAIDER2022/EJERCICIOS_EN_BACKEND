package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Equipo;
import com.amsterdam.reporteDeCasosII.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    //ATRIBUTO:
    private EquipoService equipoService;

    //CONSTRUCTOR:
    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    //METODOS:
    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo){
        return equipoService.guardarEquipo(equipo);
    }
}
