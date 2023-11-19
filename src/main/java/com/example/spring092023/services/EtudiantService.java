package com.example.spring092023.services;

import com.example.spring092023.entities.Foyer;
import com.example.spring092023.entities.Reservation;
import com.example.spring092023.entities.Universite;
import com.example.spring092023.repositories.ReservationRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Etudiant;
import com.example.spring092023.repositories.EtudiantRespository;

import java.util.Arrays;
import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantService implements iEtudiantService{

    EtudiantRespository etudiantRespository;
    ReservationRespository reservationRespository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRespository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRespository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRespository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRespository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRespository.deleteById(idEtudiant);
    }

    public void addEtudiants(List<Etudiant> etudiants){
        etudiantRespository.saveAll(etudiants);
    }

    public Etudiant affecterEtudiantAReservation(String nomEt , String prenomEt , String idReservation ){
        Etudiant etudiant = etudiantRespository.findEtudiantByNomEtAndAndPrenomEt(nomEt,prenomEt);
        Reservation reservation = reservationRespository.findReservationByIdReservation(idReservation);

        List<Reservation> reservations = etudiant.getReservations();
        reservations.add(reservation);
        etudiant.setReservations(reservations);
        reservation.getEtudiants().add(etudiant);
        return etudiantRespository.save(etudiant);
    }

}
