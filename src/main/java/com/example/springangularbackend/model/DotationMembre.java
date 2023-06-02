package com.example.springangularbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DotationMembre {
    @EmbeddedId
    private DotationMembreKey id;

    @ManyToOne
    @MapsId("MembreId")
    @JoinColumn(name = "membre_id")
    private Membre membre;

    @ManyToOne
    @MapsId("DotationID")
    @JoinColumn(name = "dotation_id")
    Dotation dotation;

    private  double montant;
}
