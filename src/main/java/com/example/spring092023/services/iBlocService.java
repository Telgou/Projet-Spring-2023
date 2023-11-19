package com.example.spring092023.services;

import com.example.spring092023.entities.Bloc;

import java.util.List;

public interface iBlocService {

    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc e);

    Bloc updateBloc(Bloc e);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);

    void listeChambresParBloc();
}
