package com.example.spring092023.services;

import com.example.spring092023.entities.Foyer;
import com.example.spring092023.repositories.FoyerRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Universite;
import com.example.spring092023.repositories.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements iUniversiteService{
    UniversiteRepository universiteRepository;
    FoyerRespository foyerRespository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversites(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Universite updateUniversites(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversites(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite  affecterFoyerAUniversite (long idFoyer, String nomUniversite){
        Universite uni = universiteRepository.findUniversiteByNomUniversite(nomUniversite);
        Foyer foyer = foyerRespository.findById(idFoyer).get();
        uni.setFoyer(foyer);
        return universiteRepository.save(uni);
    }

    @Override
    public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite){
        Universite uni = universiteRepository.findById(idUniversite).get();
        uni.setFoyer(null);
        return universiteRepository.save(uni);
    }

    @Override
    public void removeUniversites(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }
}
