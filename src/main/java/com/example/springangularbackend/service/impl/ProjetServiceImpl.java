package com.example.springangularbackend.service.impl;


import com.example.springangularbackend.dto.ProjectDTO;
import com.example.springangularbackend.model.Projet;
import com.example.springangularbackend.repository.ProjetRepository;
import com.example.springangularbackend.service.ProjetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProjetServiceImpl  implements ProjetService {

    private ProjetRepository projetRepository;

    @Autowired
    public  void ProjetServiceImpl(ProjetRepository projetRepository){
        this.projetRepository = projetRepository;
    }
    @Override
    public Projet addProjet(ProjectDTO projectDTO) {

        Projet projet = new Projet();
        projet.setTitre(projectDTO.getTitre());
        projet.setDescription(projectDTO.getDescription());
        return projetRepository.save(projet);
    }

    @Override
    public boolean UpdateProjet(int id,ProjectDTO projectDTO) {

        Projet projet = projetRepository.findById(id).get();
        projet.setTitre(projectDTO.getTitre());

        projetRepository.save(projet);
        return true;
    }

    @Override
    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<Projet> getAllProject() {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> getProejet(int id) {
        return projetRepository.findById(id);
    }


}
