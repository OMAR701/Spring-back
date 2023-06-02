package com.example.springangularbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DotationProjet extends Dotation {

    @ManyToOne
    @JoinColumn(name="projet_id", nullable=false)
    private Projet projet;
}
