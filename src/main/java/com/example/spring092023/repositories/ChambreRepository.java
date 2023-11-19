package com.example.spring092023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring092023.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.Date;
import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :bid AND c.typeC = 'DOUBLE'")
    List<Chambre> findDoubleChambresInBloc(@Param("bid") Long blocId);
    @Query("SELECT c FROM Chambre c JOIN c.Reservations r WHERE r.estValide = :estvalide")
    List<Chambre> findChambresByValidation(@Param("estvalide") boolean estValide);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.nomBloc = :nombloc ")
    List<Chambre> findChambreByBlocNomBloc(@Param("nombloc") String nombloc);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idbloc ")
    List<Chambre> findChambreByBlocIdBloc(@Param("idbloc") Long idbloc);

    @Query("SELECT count(c) FROM Chambre c WHERE c.bloc.idBloc = :idbloc AND c.typeC= :type ")
    long findnumberofchambres(@Param("idbloc") Long idbloc,@Param("type") TypeChambre type);

    @Query("SELECT count(c) FROM Chambre c WHERE c.typeC= :type ")
    long findnumberofchambresbyptype(@Param("type") TypeChambre type);

    @Query("SELECT COUNT(r) FROM Chambre c JOIN c.Reservations r WHERE c = :chambre and YEAR(r.anneeUniversitaire) = :year")
    Long findReservationsByYear(@Param("chambre") Chambre chambre, @Param("year") int year);


}
