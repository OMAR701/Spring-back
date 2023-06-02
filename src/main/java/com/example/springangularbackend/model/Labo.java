package com.example.springangularbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Labo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablisment_id", nullable = false)
    private Etablisment etablisment;


    @OneToOne(mappedBy = "labos")
    private  Directeur directeur;

    @OneToOne(mappedBy = "labo")
    private ResponsableFinanciere responsableFinanciere;

    @OneToOne(mappedBy = "labo")
    private ResponsableMarchandise responsableMarchandise;

}
