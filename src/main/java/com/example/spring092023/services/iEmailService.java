package com.example.spring092023.services;

import com.example.spring092023.entities.*;

public interface iEmailService {
    void sendReservationConfirmationEmail(Etudiant etudiant, Reservation reservation);
}
