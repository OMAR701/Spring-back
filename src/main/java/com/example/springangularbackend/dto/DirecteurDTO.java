package com.example.springangularbackend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DirecteurDTO {
    private String nom;
    private String prenom;
    private String email;
    private String Telephone;
    private String password;
    private String image;
}
