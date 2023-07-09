package com.amsterdam.reporteDeCasosII.controller;

import com.amsterdam.reporteDeCasosII.model.Usuario;
import com.amsterdam.reporteDeCasosII.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
}
