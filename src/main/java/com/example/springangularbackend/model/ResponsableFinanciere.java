package com.example.springangularbackend.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsableFinanciere extends Responsable{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labo_id", referencedColumnName = "id")
    private Labo labo;
}
