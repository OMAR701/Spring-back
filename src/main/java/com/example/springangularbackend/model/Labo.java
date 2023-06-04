package com.example.springangularbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Labo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String image;
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
