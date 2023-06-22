package com.amsterdam.registro_de_casos.service;

import com.amsterdam.registro_de_casos.dao.IDao;
import com.amsterdam.registro_de_casos.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


public class UsuarioService {
    //ESTO ES TEMPORAL:
    private IDao<Usuario> usuarioIDao;

    //CONSTRUCTOR:
    public UsuarioService(IDao<Usuario> usuarioIDao) {
        this.usuarioIDao = usuarioIDao;
    }

    //METODOS:
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioIDao.guardar(usuario);
    }

    public Usuario buscarUsuario(Integer id) {
        return usuarioIDao.buscar(id);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        usuarioIDao.actualizar(usuario);
        return usuario;
    }

    public Usuario eliminarUsuario(Integer id) {
        usuarioIDao.eliminar(id);
        return null;
    }
    public List<Usuario> buscarTodosLosUsuarios(){
        return usuarioIDao.buscarTodos();
    }

}
