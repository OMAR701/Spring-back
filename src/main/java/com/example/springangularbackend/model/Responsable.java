package com.example.springangularbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Responsable extends  Person{


    @OneToMany(mappedBy = "responsable")
    private Set<ExpressionDesBesoins> expressionDesBesoins;


}
