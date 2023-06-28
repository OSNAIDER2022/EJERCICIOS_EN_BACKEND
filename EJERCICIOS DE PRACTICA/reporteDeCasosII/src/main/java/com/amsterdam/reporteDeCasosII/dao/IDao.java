package com.amsterdam.reporteDeCasosII.dao;

import java.util.List;

public interface IDao <T>{
    List<T> buscarTodos();
    void eliminar(Integer id);
    void actualizar(T t);
    T buscar(Integer id);
    T guardar(T t);
}
