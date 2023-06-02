package com.example.springangularbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MembreProjetKey implements Serializable {
    @Column(name = "membre_id")
    Long MembreId;


    @Column(name = "projet_id")
    Long PrijetId;
}
