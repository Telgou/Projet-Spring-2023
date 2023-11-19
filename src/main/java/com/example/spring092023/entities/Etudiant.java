package com.example.spring092023.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String email;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL ,mappedBy="etudiants",fetch = FetchType.EAGER)
    private List<Reservation> reservations;



}