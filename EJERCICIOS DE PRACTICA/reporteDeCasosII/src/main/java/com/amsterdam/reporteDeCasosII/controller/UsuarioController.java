package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Usuario;
import com.amsterdam.reporteDeCasosII.service.UsuarioService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //ATRIBUTOS:
    private final UsuarioService usuarioService;

    //CONSTRUCTOR:
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //METODOS:
    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioAIngresar = usuarioService.guardarUsuario(usuario);
        if (usuarioAIngresar != null){
            return ResponseEntity.ok("Se ha logrado ingresar los datos del USUARIO: " + usuario.getNombreCompleto()+" generando el ID: " + usuario.getId());
        }else{
            return ResponseEntity.badRequest().body("Ha ocurrido un error al momento de guardar la informacion. Al parecer el usuario ya existe en la base de datos.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostrarTodosLosUsuarios(){
        if(usuarioService.buscarTodosLosUsuarios() != null){
            return ResponseEntity.ok(usuarioService.buscarTodosLosUsuarios());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id){
        Usuario usuarioIdBuscado = usuarioService.buscarUsuario(id);
        if(usuarioIdBuscado != null){
            return ResponseEntity.ok().body(usuarioService.buscarUsuario(id));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable Integer id){
        Usuario usuarioIdBuscado = usuarioService.buscarUsuario(id);
        if (usuarioIdBuscado != null){
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Se eliminó los datos del usuario de la base de datos, con el ID:" + id);
        }else{
            return ResponseEntity.badRequest().body("Ha ocurrido un error al momento de intentar eliminar la informacion con el ID: "+ id +". Por favor, chequea y vuelve a intentarlo.");
        }
    }

    @PutMapping()
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioIdBuscado = usuarioService.buscarUsuario(usuario.getId());
        if (usuarioIdBuscado != null){
            usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
