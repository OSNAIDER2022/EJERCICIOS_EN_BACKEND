package com.amsterdam.reporteDeCasosII.service;

import com.amsterdam.reporteDeCasosII.dao.IDao;
import com.amsterdam.reporteDeCasosII.dao.UsuarioH2DAO;
import com.amsterdam.reporteDeCasosII.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    //ESTO ES TEMPORAL:
    private IDao<Usuario> usuarioIDao;

    //CONSTRUCTOR:
    public UsuarioService() {
        usuarioIDao = new UsuarioH2DAO();
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
