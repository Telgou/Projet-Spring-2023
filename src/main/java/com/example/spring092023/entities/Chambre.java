package com.example.spring092023.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reservation> Reservations;
    @JsonIgnore
    @ManyToOne()
    Bloc bloc;



}