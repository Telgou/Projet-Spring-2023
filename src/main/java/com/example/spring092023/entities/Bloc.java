package com.example.spring092023.entities;
import com.fasterxml.jackson.annotation.*;
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
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER,mappedBy="bloc")
    private List<Chambre> chambres;
    @JsonIgnore
    @ManyToOne( )
    Foyer foyer;



}