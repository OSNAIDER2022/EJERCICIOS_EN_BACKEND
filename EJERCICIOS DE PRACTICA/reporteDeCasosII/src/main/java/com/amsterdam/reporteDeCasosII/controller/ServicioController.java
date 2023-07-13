package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Servicio;
import com.amsterdam.reporteDeCasosII.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    private final ServicioService servicioService;

    //CONSTRUCTOR:
    @Autowired
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    //METODOS:
    @PostMapping
    public ResponseEntity<String> guardarServicio(@RequestBody Servicio servicio){
        Servicio servicioAIngresar = servicioService.guardarServicio(servicio);
            if(servicioAIngresar != null){
                return ResponseEntity.ok("Se ha guardado los datos para el servicio: "+ servicio.getNombreDeServicio() + " con el ID: "+ servicio.getId());
            }else{
                return ResponseEntity.badRequest().body("Ha ocurrido un problema al momento de intentar ingresar los datos del servicio.");

            }
        }
    @GetMapping
    public ResponseEntity<List<Servicio>> mostrarTodosLosServicios(){
        if(servicioService.buscarTodosLosServicio() != null){
            return ResponseEntity.ok(servicioService.buscarTodosLosServicio());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Servicio> buscarServicioPorId(@PathVariable Integer id){
        Servicio servicioBuscado = servicioService.buscarServicio(id);
        if (servicioBuscado != null){
            return ResponseEntity.ok(servicioBuscado);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarServicioPorId(@PathVariable Integer id){
        Servicio servicioBuscado = servicioService.buscarServicio(id);
        if (servicioBuscado != null){
            servicioService.eliminarServicio(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se ha eliminado el servicio con el ID: " + id);
        }else {
            return ResponseEntity.badRequest().body("No se ha logrado realizar la eliminacion del servicio");
        }
    }
    @PutMapping
    public ResponseEntity<Servicio> actualizarServicio(@RequestBody Servicio servicio){
        Servicio servicioBuscado = servicioService.buscarServicio(servicio.getId());
        if (servicioBuscado != null){
            servicioService.actualizarServicio(servicio);
            return ResponseEntity.ok(servicio);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}

