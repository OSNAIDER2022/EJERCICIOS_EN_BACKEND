package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.SoporteTecnico;
import com.amsterdam.reporteDeCasosII.service.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soporte_tecnico")
public class SoporteTecnicoController {
    private final SoporteTecnicoService soporteTecnicoService;

    //CONSTRUCTOR:
    @Autowired
    public SoporteTecnicoController(SoporteTecnicoService soporteTecnicoService) {
        this.soporteTecnicoService = soporteTecnicoService;
    }
    //METODOS:
    @PostMapping
    public ResponseEntity<String> guardarSoporteTecnico(@RequestBody SoporteTecnico soporteTecnico){
        SoporteTecnico soporteTecnicoAGuardar = soporteTecnicoService.guardarSoporteTecnico(soporteTecnico);
        if (soporteTecnicoAGuardar != null){
            return ResponseEntity.ok("Se ha guardado el soporte tecnico con el ID: "+ soporteTecnico.getId()+" de asunto: "+ soporteTecnico.getAsunto());
        }else{
            return ResponseEntity.badRequest().body("Ha ocurrido un problema al momento de guardar el SOPORTE TECNICO");
        }
    }
    @GetMapping
    public ResponseEntity<List<SoporteTecnico>> mostrarTodosLosSoportesTecnicos(){
        if (soporteTecnicoService.buscarTodosLosSoportesTecnicos() != null){
            return ResponseEntity.ok(soporteTecnicoService.buscarTodosLosSoportesTecnicos());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<SoporteTecnico> buscarSoporteTecnicoPorId(@PathVariable Integer id){
        SoporteTecnico soporteTecnicoABuscar = soporteTecnicoService.buscarSoporteTecnico(id);
        if (soporteTecnicoABuscar != null){
            return ResponseEntity.ok(soporteTecnicoABuscar);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarSoporteTecnicoPorId(@PathVariable Integer id){
        SoporteTecnico soporteTecnicoABuscar = soporteTecnicoService.buscarSoporteTecnico(id);
        if (soporteTecnicoABuscar != null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se ha eliminado el SOPORTE TECNICO CON EL ID: " + id);
        }else{
            return ResponseEntity.badRequest().body("Ha ocurrido un problema al momento de intentar borrar un SOPORTE TECNICO");
        }
    }
    @PutMapping()
    public ResponseEntity<SoporteTecnico> actualizarSoporteTecnico(@RequestBody SoporteTecnico soporteTecnico){
        SoporteTecnico soporteTecnicoABuscar = soporteTecnicoService.buscarSoporteTecnico(soporteTecnico.getId());
        if (soporteTecnicoABuscar != null){
            soporteTecnicoService.actualizarSoporte(soporteTecnico);
            return ResponseEntity.ok(soporteTecnico);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
