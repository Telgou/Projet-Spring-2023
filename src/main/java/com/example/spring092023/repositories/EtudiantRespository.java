package com.example.spring092023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring092023.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EtudiantRespository extends JpaRepository<Etudiant,Long> {
    //List<Etudiant> addEtudiants (List<Etudiant> etudiants);

    @Query("SELECT e FROM Etudiant e WHERE e.nomEt = :nom and e.prenomEt= :prenom ")
    Etudiant findEtudiantByNomEtAndAndPrenomEt(@Param("nom") String nom,@Param("prenom") String prenom);


}
