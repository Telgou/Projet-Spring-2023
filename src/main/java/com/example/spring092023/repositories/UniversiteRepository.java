package com.example.spring092023.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring092023.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    //List<Universite>
    @Query("SELECT u FROM Universite u WHERE u.nomUniversite = :nom ")
    Universite findUniversiteByNomUniversite(@Param("nom") String nom);


}
