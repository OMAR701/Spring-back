package com.example.springangularbackend.service;


import com.example.springangularbackend.dto.ProjectDTO;
import com.example.springangularbackend.model.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {

    public Projet addProjet(ProjectDTO projectDTO);

    public boolean UpdateProjet(int id,ProjectDTO projectDTO);

    public void deleteProjet(int id);

    public List<Projet> getAllProject();

    public Optional<Projet> getProejet(int id);
}
