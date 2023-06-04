package com.example.springangularbackend.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DotationDTO {

    private String titre;
    private double montant_total;
}
