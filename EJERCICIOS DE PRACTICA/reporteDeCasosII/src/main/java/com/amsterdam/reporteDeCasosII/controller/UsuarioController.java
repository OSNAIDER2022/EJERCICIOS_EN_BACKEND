package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Usuario;
import com.amsterdam.reporteDeCasosII.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    //ATRIBUTOS:
    private UsuarioService usuarioService;

    //CONSTRUCTOR:
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //METODOS:
    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        if (usuario.getId() != null){
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.ok("De ha guardado el usuario con el ID: "+ usuario.getId() +" de forma exitosa");
        }else{
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarUsuarioPorId(@PathVariable Integer id){
        if(usuarioService.buscarUsuario(id) != null){
            usuarioService.buscarUsuario(id);
            return ResponseEntity.ok("Se ha realizado la busqueda del usuario con el ID: "+ id);
        }else{
            return ResponseEntity.badRequest().body("No se ha logrado encontrar el usuario con el ID: "+ id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario){
        if (usuarioService.buscarUsuario(usuario.getId()) != null){
            usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok("Se ha guardado con exito los datos del usuario con el ID: "+usuario.getId());
        }else{
            return ResponseEntity.badRequest().body("No se ha logrado actualizar los datos del usuario con el ID: "+usuario.getId());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuarioPorId(@PathVariable Integer id){
        if(usuarioService.buscarUsuario(id) != null){
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se ha eliminado el usuario con el ID: " + id + " de forma exitosa!!");
        }else{
            return ResponseEntity.badRequest().body("No se ha encontrado el usuario con el ID: "+ id +" en la base de datos.");
        }
    }
}
