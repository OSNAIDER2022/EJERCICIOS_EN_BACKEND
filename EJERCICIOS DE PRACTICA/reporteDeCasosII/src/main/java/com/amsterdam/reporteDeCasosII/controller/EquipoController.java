package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Equipo;
import com.amsterdam.reporteDeCasosII.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
    private final EquipoService equipoService;

    //CONSTRUCTOR:
    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    //METODOS:
    @PostMapping
    public ResponseEntity<String> guardarEquipo(@RequestBody Equipo equipo){
        Equipo equipoAIngresar = equipoService.guardarEquipo(equipo);
        if (equipoAIngresar != null){
            return  ResponseEntity.ok("Se ha ingresado a la base de datos el equipo de modelo: " + equipo.getModelo() + ", y serial: "+ equipo.getSerial()+", con el ID: "+ equipo.getId());
        }else {
            return  ResponseEntity.badRequest().body("Ha ocurrido un error al momento de intentar ingresar los datos del equipo a la base de datos.");
        }
    }
    @GetMapping
    public ResponseEntity<List<Equipo>> mostrarTodosLosEquipos(){
        if (equipoService.buscarTodosLosEquipos() != null){
            return ResponseEntity.ok().body(equipoService.buscarTodosLosEquipos());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Equipo> buscarEquipoPorId(@PathVariable Integer id){
        Equipo equipoABuscar = equipoService.buscarEquipo(id);
        if (equipoABuscar != null){
            return ResponseEntity.ok(equipoService.buscarEquipo(id));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarEquipoPorId(@PathVariable Integer id){
        Equipo equipoABuscar = equipoService.buscarEquipo(id);
        if (equipoABuscar != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se ha eliminado los datos para el usuario");
        }else {
            return ResponseEntity.badRequest().body("No se ha logrado realizar la eliminacion del equipo");
        }
    }

    @PutMapping
    public ResponseEntity<Equipo> actualizarEquipo(@RequestBody Equipo equipo){
        Equipo equipoABuscar = equipoService.buscarEquipo(equipo.getId());
        if (equipoABuscar != null){
            equipoService.actualizarEquipo(equipo);
            return ResponseEntity.ok(equipo);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
