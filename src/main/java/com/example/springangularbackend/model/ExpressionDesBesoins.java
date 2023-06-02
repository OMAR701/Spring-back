package com.example.springangularbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpressionDesBesoins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  TypeExpression type;
    private  String titre;
    private Date Date_de_Demande;
    private Date Date_de_validation_par_Directeur;
    private Date date_effec;
    private double montant_effectif;

    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private  Responsable responsable;

}
