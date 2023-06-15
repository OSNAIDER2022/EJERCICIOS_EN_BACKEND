package com.amsterdam.clinicaOdontologica.dao;

import java.util.List;

public interface IDao <T>{
    T guardar(T t);
    T buscar (Integer id);
    void actualizar(T t);
    void eliminar(Integer id);
    List<T> buscarTodos();
    T buscarPorString(String valor);
}
