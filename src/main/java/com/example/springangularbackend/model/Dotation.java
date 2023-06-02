package com.example.springangularbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Dotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double montant_total;
    private Date DateAffectation;

    @OneToMany(mappedBy = "dotation")
    private Set<DotationMembre> dotationMembres;

}
