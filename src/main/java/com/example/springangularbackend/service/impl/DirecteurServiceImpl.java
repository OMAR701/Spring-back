package com.example.springangularbackend.service.impl;


import com.example.springangularbackend.dto.DotationDTO;
import com.example.springangularbackend.dto.PersonDTO;
import com.example.springangularbackend.dto.ProjectDTO;
import com.example.springangularbackend.model.*;
import com.example.springangularbackend.repository.*;
import com.example.springangularbackend.service.DirecteurService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class DirecteurServiceImpl implements DirecteurService {

    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    MemberPrejtRepository memberPrejtRepository;

    @Autowired
    MembreRepository membreRepository;
    @Autowired
    DotationProjetRepository dotationProjetRepository;

    @Autowired
    DotationMemberRepository dotationMemberRepository;
    @Autowired
    ExpressionDesBesoinsRepository expressionDesBesoinsRepository;

    @Override
    public Membre addMember(PersonDTO personDTO, List<Integer> listMemberProjets) {

        Set<MembreProjet> membreProjets = new HashSet<>();
        Membre membre = new Membre();
        membre.setNom(personDTO.getNom());
        membre.setPrenom(personDTO.getPrenom());
        membre.setEmail(personDTO.getEmail());
        membre.setPassword(personDTO.getPassword());
        membre.setImage(personDTO.getImage());
        membre.setTelephone(personDTO.getTelephone());
        membre.setRoles(new ArrayList<>(Arrays.asList(new Role("Member"))));
        for (int index: listMemberProjets) {
            Projet projet = projetRepository.findById(index).get();
            MembreProjet  membreProjet = new MembreProjet();
            membreProjet.setMembre(membre);
            membreProjet.setProjet(projet);
            membreProjet.setRespo(false);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        membre.setMembreProjets(membreProjets);
        return membreRepository.save(membre);
    }

    @Override
    public Membre updateMember(int id, PersonDTO personDTO,List<Integer> listMemberProjets,List<Integer> dotationProjetList) {

        Set<MembreProjet> membreProjets = new HashSet<>();
        Membre membre = membreRepository.findById(id).get();
        Set<DotationMembre> dotationMembres = new HashSet<>();
        membre.setNom(personDTO.getNom());
        membre.setPrenom(personDTO.getPrenom());
        membre.setEmail(personDTO.getEmail());
        membre.setPassword(personDTO.getPassword());
        membre.setImage(personDTO.getImage());
        membre.setTelephone(personDTO.getTelephone());
        membre.setRoles(new ArrayList<>(Arrays.asList(new Role("Member"))));
        for (int index: listMemberProjets) {
            Projet projet = projetRepository.findById(index).get();
            MembreProjet  membreProjet = new MembreProjet();
            membreProjet.setMembre(membre);
            membreProjet.setProjet(projet);
            membreProjet.setRespo(false);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        for (int index: dotationProjetList) {
            DotationProjet dotationProjet = dotationProjetRepository.findById(index).get();
            DotationMembre dotationMembre = new DotationMembre();
            dotationMembre.setDotation(dotationProjet);
            dotationMembre.setMembre(membre);
            dotationMembre.setMontant(dotationProjet.getMontant_total()/3);
            dotationMemberRepository.save(dotationMembre);
            dotationMembres.add(dotationMembre);
        }
        membre.setMembreProjets(membreProjets);
        membre.setDotationMembres(dotationMembres);
        return membreRepository.save(membre);
    }

    @Override
    public void deleteMember(int id) {
        membreRepository.deleteById(id);
    }

    @Override
    public DotationProjet addDotationProjet(DotationDTO dotationDTO, List<Integer> listMembers, int idProjet) {
        Date currentDate = new Date();
        Set<Membre> members = new HashSet<>();
        Set<DotationMembre> dotationMembres = new HashSet<>();
        DotationProjet dotationProjet = new DotationProjet();
        dotationProjet.setTitre(dotationDTO.getTitre());
        dotationProjet.setDateAffectation(currentDate);
        dotationProjet.setMontant_total(dotationDTO.getMontant_total());
        dotationProjet.setProjet(projetRepository.findById(idProjet).get());
        for (int index: listMembers) {
            DotationMembre dotationMembre = new DotationMembre();
            Membre membre = membreRepository.findById(index).get();
            dotationMembre.setMembre(membre);
            dotationMembre.setDotation(dotationProjet);
            dotationMembre.setMontant(dotationProjet.getMontant_total()/listMembers.size());
            dotationMemberRepository.save(dotationMembre);
            dotationMembres.add(dotationMembre);
        }
        dotationProjet.setDotationMembres(dotationMembres);
        return dotationProjetRepository.save(dotationProjet);

    }

    @Override
    public DotationProjet updateDotationProjet(int id, DotationDTO dotationDTO, List<Integer> listMembers, int idProjet) {
        Date currentDate = new Date();
        Set<Membre> members = new HashSet<>();
        Set<DotationMembre> dotationMembres = new HashSet<>();
        DotationProjet dotationProjet = dotationProjetRepository.findById(id).get();
        dotationProjet.setTitre(dotationDTO.getTitre());
        dotationProjet.setDateAffectation(currentDate);
        dotationProjet.setMontant_total(dotationDTO.getMontant_total());
        dotationProjet.setProjet(projetRepository.findById(idProjet).get());
        for (int index: listMembers) {
            DotationMembre dotationMembre = new DotationMembre();
            Membre membre = membreRepository.findById(index).get();
            dotationMembre.setMembre(membre);
            dotationMembre.setDotation(dotationProjet);
            dotationMembre.setMontant(dotationProjet.getMontant_total()/listMembers.size());
            dotationMemberRepository.save(dotationMembre);
            dotationMembres.add(dotationMembre);
        }
        dotationProjet.setDotationMembres(dotationMembres);
        return dotationProjetRepository.save(dotationProjet);

    }

    @Override
    public void deleteDotationProjet(int id) {
        dotationProjetRepository.deleteById(id);
    }

    @Override
    public Projet addProjet(ProjectDTO projectDTO, List<Integer>  dotationProjetList, List<Integer>  membreList) {
        Date currentDate = new Date();
        Projet projet = new Projet();
        Set<MembreProjet> membreProjets = new HashSet<>();
        Set<DotationProjet> dotationProjets = new HashSet<>();
        projet.setTitre(projectDTO.getTitre());
        projet.setDescription(projectDTO.getDescription());
        for (int index: membreList) {
            Membre membre = membreRepository.findById(index).get();
            MembreProjet membreProjet = new MembreProjet();
            membreProjet.setProjet(projet);
            membreProjet.setMembre(membre);
            membreProjet.setRespo(true);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        for (int index: dotationProjetList) {
            DotationProjet dotationProjet = new DotationProjet();
            Dotation dotation = dotationProjetRepository.findById(index).get();
            dotationProjet.setProjet(projet);
            dotationProjet.setTitre(dotation.getTitre());
            dotationProjet.setDotationMembres(dotation.getDotationMembres());
            dotationProjet.setDateAffectation(currentDate);
            dotationProjet.setMontant_total(dotation.getMontant_total());
            dotationProjetRepository.save(dotationProjet);
            dotationProjets.add(dotationProjet);
        }
        projet.setDotationProjets(dotationProjets);
        projet.setMembreProjets(membreProjets);
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(int id, ProjectDTO projectDTO, List<Integer>  dotationProjetList, List<Integer>  membreList) {
        Date currentDate = new Date();
        Projet projet = projetRepository.findById(id).get();
        Set<MembreProjet> membreProjets = new HashSet<>();
        Set<DotationProjet> dotationProjets = new HashSet<>();
        projet.setTitre(projectDTO.getTitre());
        projet.setDescription(projectDTO.getDescription());
        for (int index: membreList) {
            Membre membre = membreRepository.findById(index).get();
            MembreProjet membreProjet = new MembreProjet();
            membreProjet.setProjet(projet);
            membreProjet.setMembre(membre);
            membreProjet.setRespo(true);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        for (int index: dotationProjetList) {
            DotationProjet dotationProjet = new DotationProjet();
            Dotation dotation = dotationProjetRepository.findById(index).get();
            dotationProjet.setProjet(projet);
            dotationProjet.setTitre(dotation.getTitre());
            dotationProjet.setDotationMembres(dotation.getDotationMembres());
            dotationProjet.setDateAffectation(currentDate);
            dotationProjet.setMontant_total(dotation.getMontant_total());
            dotationProjetRepository.save(dotationProjet);
            dotationProjets.add(dotationProjet);
        }
        projet.setDotationProjets(dotationProjets);
        projet.setMembreProjets(membreProjets);
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }

    @Override
    public void AcceptExperssion(int IdexpressionDesBesoins) {
        ExpressionDesBesoins expressionDesBesoins = expressionDesBesoinsRepository.findById(IdexpressionDesBesoins).get();
        expressionDesBesoins.setStatus(true);
        expressionDesBesoinsRepository.save(expressionDesBesoins);
    }
}
