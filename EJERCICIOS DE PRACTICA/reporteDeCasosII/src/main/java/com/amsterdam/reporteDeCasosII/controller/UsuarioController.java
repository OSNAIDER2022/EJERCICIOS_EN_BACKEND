package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Usuario;
import com.amsterdam.reporteDeCasosII.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return  usuarioService.guardarUsuario(usuario);
    }

    //@GetMapping
    @PutMapping
    public String actualizarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioBuscado = usuarioService.buscarUsuario(usuario.getId());
        if (usuarioBuscado != null){
            usuarioService.actualizarUsuario(usuario);
            return "Se ha actualizado exitosamente los datos del USUARIO con el ID: " + usuario.getId();
        }else{
            return "No se ha logrado encontrar el usuario con el ID: " + usuario.getId() + " en la base de datos.";
        }
    }


    @DeleteMapping
    public String eliminarUsuario(Model model, @RequestParam("id") Integer id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        if (usuario != null){
            usuarioService.eliminarUsuario(usuario.getId());
            return "Se han eliminado los datos del usuario con el ID " + usuario.getId() + " de la base de datos.";
        }else{
            return "No se ha logrado encontrar el usuario a eliminar en la base de datos.";
        }
    }

}
