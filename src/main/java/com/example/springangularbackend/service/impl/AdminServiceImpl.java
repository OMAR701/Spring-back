package com.example.springangularbackend.service.impl;

import com.example.springangularbackend.dto.DirecteurDTO;
import com.example.springangularbackend.dto.LaboDTO;
import com.example.springangularbackend.dto.ResponsableFinanciereDTO;
import com.example.springangularbackend.dto.ResponsableMarchandiseDTO;
import com.example.springangularbackend.model.*;
import com.example.springangularbackend.repository.*;
import com.example.springangularbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    LaboRepository laboRepository;
    @Autowired
    DirecteurRepository directeurRepository;
    @Autowired
    ResponsableMarchandiseRepository responsableMarchandiseRepository;
    @Autowired
    ReponsableFinanciereRepository reponsableFinanciereRepository;

    @Override
    public Directeur AddDirecteur(DirecteurDTO directeurDTO) {
        Directeur directeur = new Directeur();
        directeur.setEmail(directeurDTO.getEmail());
        directeur.setNom(directeurDTO.getNom());
        directeur.setPrenom(directeurDTO.getPrenom());
        directeur.setPassword(directeurDTO.getPassword());
        directeur.setRoles(new ArrayList<>(Arrays.asList(new Role("Directeur"), new Role("Member"))));
        return directeurRepository.save(directeur);
    }

    @Override
    public void deleteDirecteur(int id) {
         directeurRepository.deleteById(id);
    }

    @Override
    public Labo AddLabo(LaboDTO laboDTO) {
        return null;
    }

    @Override
    public void affectDirecteurToLabo(int idDirecteur, int idLAbo) {
         Directeur dir = directeurRepository.findById(idDirecteur).get();
         Labo labo = laboRepository.findById(idLAbo).get();
         labo.setDirecteur(dir);
         laboRepository.save(labo);
         dir.setLabos(labo);
         directeurRepository.save(dir);

    }

    @Override
    public ResponsableFinanciere respoFinAdd(ResponsableFinanciereDTO responsableFinanciereDTO) {
        return null;
    }

    @Override
    public ResponsableMarchandise respoMarAdd(ResponsableMarchandiseDTO responsableMarchandiseDTO) {
        return null;
    }

    @Override
    public ResponsableFinanciere respoFinDelete(int id) {
        return null;
    }

    @Override
    public ResponsableMarchandise respoMarDelete(int id) {
        return null;
    }
}
