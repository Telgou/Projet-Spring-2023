package com.example.spring092023.services;

import com.example.spring092023.entities.Etudiant;
import com.example.spring092023.repositories.ChambreRepository;
import com.example.spring092023.repositories.EtudiantRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.spring092023.entities.Reservation;
import com.example.spring092023.repositories.ReservationRespository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements iReservationService {

    ReservationRespository reservationRespository;
    EtudiantRespository etudiantRespository;
    ChambreService chambreService;
    EmailService emailService;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRespository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation, Long idEtudiant, Long idChambre) {
        Etudiant etudiant = etudiantRespository.findById(idEtudiant).orElse(null);
        if (etudiant != null) {
            List<Reservation> newReservations = etudiant.getReservations();
            newReservations.add(reservation);
            etudiant.setReservations(newReservations);
            etudiantRespository.save(etudiant);

            Reservation savedReservation = reservationRespository.save(reservation);
            chambreService.affecterReservationAChambre(idChambre,reservation.getIdReservation());
            // Send email after successfully saving the reservation
            emailService.sendReservationConfirmationEmail(etudiant, savedReservation);
            return savedReservation;
        } else {
            return null;
        }
    }

    @Override
    public Reservation updateReservation(Reservation e) {
        return reservationRespository.save(e);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRespository.findById(idReservation).get();
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRespository.deleteById(idReservation);

    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return (reservationRespository.findReservationByAnneeUniversitaire(dateDebut, dateFin));
    }

}
