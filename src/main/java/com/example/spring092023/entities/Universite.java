package com.example.spring092023.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;

    @JsonIgnore
    @OneToOne(  )
    private Foyer foyer;



}