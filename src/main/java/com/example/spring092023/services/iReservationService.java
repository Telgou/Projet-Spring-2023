package com.example.spring092023.services;

import com.example.spring092023.entities.Etudiant;
import com.example.spring092023.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface iReservationService {

    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation reservation, Long idEtudiant, Long idChambre);

    Reservation updateReservation(Reservation e);

    Reservation retrieveReservation(Long idReservation);

    void removeReservation(Long idReservation);

    List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin );


}
