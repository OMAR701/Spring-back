package com.example.springangularbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Directeur extends  Membre{


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labo_id", referencedColumnName = "id")
    private Labo labos;
}
