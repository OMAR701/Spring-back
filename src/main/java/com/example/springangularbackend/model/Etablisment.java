package com.example.springangularbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etablisment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String ville;


    @OneToMany(mappedBy = "etablisment")
    private Set<Labo> labos;
}
