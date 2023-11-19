package com.example.spring092023.services;

import com.example.spring092023.entities.Bloc;
import com.example.spring092023.entities.Chambre;
import com.example.spring092023.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Foyer;
import com.example.spring092023.repositories.FoyerRespository;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerService implements iFoyerService{

    private final FoyerRespository foyerRespository;
    private final BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRespository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRespository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRespository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRespository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRespository.deleteById(idFoyer);
    }
    public void archiverFoyer (long idFoyer){
        Foyer foyer = foyerRespository.findById(idFoyer).get();
        foyer.setArchived(true);
        foyerRespository.save(foyer);
    };

    public Foyer addFoyerwithBloc(Foyer foyer){
        Foyer f1=foyerRespository.save(foyer);
        List<Bloc> blocs = f1.getBloc();
        for (Bloc bloc : blocs) {
            bloc.setFoyer(f1);
        }
        blocRepository.saveAll(blocs);
        return(f1);
    }

}