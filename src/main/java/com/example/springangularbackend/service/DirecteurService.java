package com.example.springangularbackend.service;

import com.example.springangularbackend.dto.DotationDTO;
import com.example.springangularbackend.dto.PersonDTO;
import com.example.springangularbackend.dto.ProjectDTO;
import com.example.springangularbackend.model.DotationProjet;
import com.example.springangularbackend.model.ExpressionDesBesoins;
import com.example.springangularbackend.model.Membre;
import com.example.springangularbackend.model.Projet;

import java.util.List;
import java.util.Optional;

public interface DirecteurService {



    public Membre addMember(PersonDTO personDTO, List<Integer> listMemberProjets);
    public Membre updateMember(int id, PersonDTO personDTO,List<Integer> listMemberProjets,List<Integer> dotationProjetList);
    public void deleteMember(int id);

    public DotationProjet addDotationProjet(DotationDTO dotationDTO, List<Integer> listMembers, int idProjet);
    public DotationProjet updateDotationProjet(int id, DotationDTO dotationDTO, List<Integer> listMembers, int idProjet);
    public void deleteDotationProjet(int id);

    public Projet addProjet(ProjectDTO projectDTO, List<Integer>  dotationProjetList, List<Integer>  membreList);
    public Projet updateProjet(int id, ProjectDTO projectDTO, List<Integer>  dotationProjetList, List<Integer>  membreList);
    public void deleteProjet(int id);

    public void AcceptExperssion(int IdexpressionDesBesoins);

}
