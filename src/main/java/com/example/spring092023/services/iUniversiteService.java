package com.example.spring092023.services;

import com.example.spring092023.entities.Universite;

import java.util.List;

public interface iUniversiteService {

    List<Universite> retrieveAllUniversites();

    Universite addUniversites(Universite e);

    Universite updateUniversites(Universite e);

    Universite retrieveUniversites(Long idUniversite);

    Universite  affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite  desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;

    void removeUniversites(Long idUniversite);
}
