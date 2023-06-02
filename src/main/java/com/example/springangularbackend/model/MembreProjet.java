package com.example.springangularbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembreProjet {
    @EmbeddedId
    private MembreProjetKey id;


    @ManyToOne
    @MapsId("MembreId")
    @JoinColumn(name = "membre_id")
    private Membre membre;

    @ManyToOne
    @MapsId("ProjetID")
    @JoinColumn(name = "projet_id")
    Projet projet;
}
