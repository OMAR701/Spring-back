package com.example.springangularbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;

    @OneToMany(mappedBy = "projet")
    private Set<MembreProjet> membreProjets;

    @OneToMany(mappedBy = "projet")
    private Set<DotationProjet> dotationProjets;
}
