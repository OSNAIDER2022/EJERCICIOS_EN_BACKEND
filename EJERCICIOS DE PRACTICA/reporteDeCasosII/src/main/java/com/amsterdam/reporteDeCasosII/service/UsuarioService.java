package com.amsterdam.reporteDeCasosII.service;

import com.amsterdam.reporteDeCasosII.dao.IDao;
import com.amsterdam.reporteDeCasosII.dao.UsuarioH2DAO;
import com.amsterdam.reporteDeCasosII.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private IDao<Usuario> usuarioIDao;

    //ESTO ES TEMPORAL:
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

    public void actualizarUsuario(Usuario usuario) { usuarioIDao.actualizar(usuario);
    }

    public void eliminarUsuario(Integer id) { usuarioIDao.eliminar(id); }
    public List<Usuario> buscarTodosLosUsuarios(){
        return usuarioIDao.buscarTodos();
    }

}
