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
@Table( name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idFoyer")
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    private boolean archived = false;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "foyer")
    private List<Bloc> bloc;
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;





}