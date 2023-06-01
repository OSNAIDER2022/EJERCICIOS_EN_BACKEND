package com.amsterdam.patron_MVC.service;

import com.amsterdam.patron_MVC.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImplementador implements EntrenadorService{
    @Override
    public List<Entrenador> obtenerListaDeEntrenadores() {
        return Arrays.asList(new Entrenador("Andres"),new Entrenador("Juan"));
    }
}
