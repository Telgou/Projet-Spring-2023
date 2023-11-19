package com.example.spring092023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring092023.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRespository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire BETWEEN :datedebut AND :datefin  ")
    List<Reservation> findReservationByAnneeUniversitaire(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);

    @Query("SELECT r FROM Reservation r WHERE r.idReservation= :id  ")
    Reservation findReservationByIdReservation(@Param("id") String id);

}
