package com.example.spring092023.services;

import com.example.spring092023.entities.Chambre;
import com.example.spring092023.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Bloc;
import com.example.spring092023.repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocService implements iBlocService{
    //    EtudiantRespository etudiantRespository;

    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc e) {
        return blocRepository.save(e);
    }

    @Override
    public Bloc updateBloc(Bloc e) {
        return blocRepository.save(e);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    @Scheduled(cron = "*/60 * * * * *")
    public void listeChambresParBloc(){
        List<Bloc> blocs = blocRepository.findAll();
        for (Bloc bloc: blocs) {
            String nombloc = bloc.getNomBloc();

            log.info("Bloc : "+nombloc+" ayant une capacite de : "+bloc.getCapaciteBloc());

            List<Chambre> chambres = bloc.getChambres();
            if (!chambres.isEmpty()){
                log.info("Liste des chambres du bloc "+nombloc+" :");
            }

            for (Chambre chambre : chambres) {
                log.info("Chambre numero "+chambre.getIdChambre()+" de type "+chambre.getTypeC());
            }
        }
    }

}