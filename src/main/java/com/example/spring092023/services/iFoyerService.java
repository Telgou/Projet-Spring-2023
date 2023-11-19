package com.example.spring092023.services;

import com.example.spring092023.entities.Foyer;

import java.util.List;

public interface iFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer e);

    Foyer updateFoyer(Foyer e);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);
    void archiverFoyer (long idFoyer);

    Foyer addFoyerwithBloc(Foyer foyer);
}
