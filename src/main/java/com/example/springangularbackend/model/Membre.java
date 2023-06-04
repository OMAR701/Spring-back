package com.example.springangularbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membre extends Person{

    @OneToMany(mappedBy = "membre")
    private Set<DotationMembre> dotationMembres;

    @OneToMany(mappedBy = "membre")
    private Set<MembreProjet> membreProjets;

    @OneToMany(mappedBy = "membre")
    private  Set<ExpressionDesBesoins> expressionDesBesoins;


}
