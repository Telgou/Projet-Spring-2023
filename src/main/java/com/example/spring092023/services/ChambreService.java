package com.example.spring092023.services;

import com.example.spring092023.entities.Bloc;
import com.example.spring092023.entities.Reservation;
import com.example.spring092023.entities.TypeChambre;
import com.example.spring092023.repositories.BlocRepository;
import com.example.spring092023.repositories.ReservationRespository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Chambre;
import com.example.spring092023.repositories.ChambreRepository;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ChambreService implements iChambreService{

    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    ReservationRespository reservationRespository;
    @Override
    public List<Chambre> retrieveAllChambers() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre updateChambre(Chambre e) {
        return chambreRepository.save(e);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findBlocByNomBloc(nomBloc);
        List<Chambre> chambres = chambreRepository.findAllById(numChambre);

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);
        return blocRepository.save(bloc);
    }

    @Override
    public List<Chambre> getChambresParNomBloc ( String nomBloc ){
        List<Chambre> chambres = chambreRepository.findChambreByBlocNomBloc(nomBloc);
        return chambres;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc ){
        long x= 0;
        x = chambreRepository.findnumberofchambres(idBloc,type);
        return (x);
    }

    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre(){
        log.info("nbTotalsChambres : "+chambreRepository.findAll().size());
        for (TypeChambre type : TypeChambre.values()) {
            log.info("le pourcentage des chambrespour le type "+type+" est égale a "+chambreRepository.findnumberofchambresbyptype(type));
        }
    }

    @Override
    public Chambre affecterReservationAChambre(Long id, String idreserv){
        Chambre chambre = chambreRepository.findById(id).get();
        Reservation reservation= reservationRespository.findReservationByIdReservation(idreserv);

        List<Reservation> newreservations = chambre.getReservations();
        newreservations.add(reservation);
        chambre.setReservations(newreservations);

        for (Reservation reservations: newreservations ) {
            reservations.setChambre(chambre);
            reservationRespository.save( reservations );
        }
        return (chambreRepository.save(chambre));
    }


    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void nbPlacesDisponibleParChambreAnneeEnCours(){
        List<Chambre> chambres = chambreRepository.findAll();
        int currentYear = Year.now().getValue();
        for (Chambre chambre : chambres) {
            long currentYearReservationsCount = chambreRepository.findReservationsByYear(chambre,currentYear);
            long placesleft = switch (chambre.getTypeC()) {
                case SIMPLE -> 1 - currentYearReservationsCount;
                case DOUBLE -> 2 - currentYearReservationsCount;
                case TRIPLE -> 3 - currentYearReservationsCount;
                default -> 0;
            };

            log.info("nb places restants en "+ currentYear +" pour la chambre "+ chambre.getNumeroChambre()
                    +" est egale a "+ placesleft);
        }
    }


}