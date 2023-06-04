package com.example.springangularbackend.service.impl;

import com.example.springangularbackend.dto.*;
import com.example.springangularbackend.model.*;
import com.example.springangularbackend.repository.*;
import com.example.springangularbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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
    ReponsableFinanciereRepository responsableFinanciereRepository;
    @Autowired
    MemberPrejtRepository  memberPrejtRepository;
    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    DotationRepository dotationRepository;
    @Autowired
    DotationMemberRepository dotationMemberRepository;
    @Autowired
    DotationProjetRepository dotationProjetRepository;
    @Autowired
    DotationUcaRepository dotationUcaRepository;
    @Autowired
    EtablissementRepository etablissementRepository;

    @Override
    public Directeur AddDirecteur(DirecteurDTO directeurDTO, List<Integer> listProjets, List<Integer> dotationList) {
        Directeur directeur = new Directeur();
        Set<MembreProjet> membreProjets = new HashSet<>();
        Set<DotationMembre> dotationMembres = new HashSet<>();
        for(int index: listProjets){
            Projet projet = projetRepository.findById(index).get();
            MembreProjet  membreProjet = new MembreProjet();
            membreProjet.setMembre(directeur);
            membreProjet.setProjet(projet);
            membreProjet.setRespo(false);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        for (int index: dotationList) {
            Dotation dotation = dotationRepository.findById(index).get();
            DotationMembre dotationMembre = new DotationMembre();
            dotationMembre.setDotation(dotation);
            dotationMembre.setMembre(directeur);
            dotationMembre.setMontant(dotation.getMontant_total()/2);
            dotationMemberRepository.save(dotationMembre);
            dotationMembres.add(dotationMembre);
        }
        directeur.setEmail(directeurDTO.getEmail());
        directeur.setNom(directeurDTO.getNom());
        directeur.setPrenom(directeurDTO.getPrenom());
        directeur.setPassword(directeurDTO.getPassword());
        directeur.setImage(directeurDTO.getImage());
        directeur.setMembreProjets(membreProjets);
        directeur.setDotationMembres(dotationMembres);
        directeur.setRoles(new ArrayList<>(Arrays.asList(new Role("Directeur"), new Role("Member"))));
        return directeurRepository.save(directeur);
    }

    @Override
    public void updateDirecteur(int id, DirecteurDTO directeurDTO,List<Integer> listProjets, List<Integer> dotationList) {
        Directeur directeur = directeurRepository.findById(id).get();
        Set<MembreProjet> membreProjets = new HashSet<>();
        Set<DotationMembre> dotationMembres = new HashSet<>();
        for(int index: listProjets){
            Projet projet = projetRepository.findById(index).get();
            MembreProjet  membreProjet = new MembreProjet();
            membreProjet.setMembre(directeur);
            membreProjet.setProjet(projet);
            membreProjet.setRespo(false);
            memberPrejtRepository.save(membreProjet);
            membreProjets.add(membreProjet);
        }
        for (int index: dotationList) {
            Dotation dotation = dotationRepository.findById(index).get();
            DotationMembre dotationMembre = new DotationMembre();
            dotationMembre.setDotation(dotation);
            dotationMembre.setMembre(directeur);
            dotationMembre.setMontant(dotation.getMontant_total()/2);
            dotationMemberRepository.save(dotationMembre);
            dotationMembres.add(dotationMembre);
        }
        directeur.setEmail(directeurDTO.getEmail());
        directeur.setNom(directeurDTO.getNom());
        directeur.setPrenom(directeurDTO.getPrenom());
        directeur.setPassword(directeurDTO.getPassword());
        directeur.setImage(directeurDTO.getImage());
        directeur.setMembreProjets(membreProjets);
        directeur.setDotationMembres(dotationMembres);
        directeur.setRoles(new ArrayList<>(Arrays.asList(new Role("Directeur"), new Role("Member"))));
        directeurRepository.save(directeur);
    }

    @Override
    public void deleteDirecteur(int id) {
         directeurRepository.deleteById(id);
    }

    @Override
    public Labo AddLabo(LaboDTO laboDTO, int directeur,int RespoMarch, int RespoFinan, int idEta) {
        Labo labo = new Labo();
        labo.setTitre(laboDTO.getTitre());
        labo.setDescription(laboDTO.getDescription());
        labo.setImage(laboDTO.getImage());
        labo.setDirecteur(directeurRepository.findById(directeur).get());
        labo.setEtablisment(etablissementRepository.findById(idEta).get());
        labo.setResponsableFinanciere(responsableFinanciereRepository.findById(RespoFinan).get());
        labo.setResponsableMarchandise(responsableMarchandiseRepository.findById(RespoMarch).get());
        return laboRepository.save(labo);
    }

    @Override
    public Labo UpdateLabo(int id, LaboDTO laboDTO, int directeur, int RespoMarch, int RespoFinan, int idEta) {
        Labo labo = laboRepository.findById(id).get();
        labo.setTitre(laboDTO.getTitre());
        labo.setDescription(laboDTO.getDescription());
        labo.setImage(laboDTO.getImage());
        labo.setDirecteur(directeurRepository.findById(directeur).get());
        labo.setEtablisment(etablissementRepository.findById(idEta).get());
        labo.setResponsableFinanciere(responsableFinanciereRepository.findById(RespoFinan).get());
        labo.setResponsableMarchandise(responsableMarchandiseRepository.findById(RespoMarch).get());
        return laboRepository.save(labo);
    }

    @Override
    public void DeleteLabo(int id) {
        laboRepository.deleteById(id);
    }

    @Override
    public Etablisment AddEtablissmenet(EtablismentDTO etablismentDTO, List<Integer> listLabo) {
        Etablisment etablisment = new Etablisment();
        Set<Labo> laboList = new HashSet<>();
        etablisment.setNom(etablismentDTO.getNom());
        etablisment.setVille(etablismentDTO.getVille());
        for (int labo:listLabo) {
            laboList.add(laboRepository.findById(labo).get());
        }
        etablisment.setLabos(laboList);
        return etablissementRepository.save(etablisment);
    }

    @Override
    public Etablisment UpdateEtablisment(int id, EtablismentDTO etablismentDTO, List<Integer> listLabo) {
        Etablisment etablisment = etablissementRepository.findById(id).get();
        Set<Labo> laboList = new HashSet<>();
        etablisment.setNom(etablismentDTO.getNom());
        etablisment.setVille(etablismentDTO.getVille());
        for (int labo:listLabo) {
            laboList.add(laboRepository.findById(labo).get());
        }
        etablisment.setLabos(laboList);
        return etablissementRepository.save(etablisment);
    }

    @Override
    public void DeleteEtablissement(int id) {
        etablissementRepository.deleteById(id);
    }

    @Override
    public void updateLbo(int id, LaboDTO laboDTO, int directeur,int RespoMarch, int RespoFinan, int idEta) {

        Labo labo = laboRepository.findById(id).get();
        labo.setTitre(laboDTO.getTitre());
        labo.setDescription(laboDTO.getDescription());
        labo.setImage(laboDTO.getImage());
        labo.setDirecteur(directeurRepository.findById(directeur).get());
        labo.setEtablisment(etablissementRepository.findById(idEta).get());
        labo.setResponsableFinanciere(responsableFinanciereRepository.findById(RespoFinan).get());
        labo.setResponsableMarchandise(responsableMarchandiseRepository.findById(RespoMarch).get());

    }



    @Override
    public ResponsableFinanciere respoFinAdd(ResponsableFinanciereDTO responsableFinanciereDTO, int IdLabo) {
        ResponsableFinanciere responsableFinanciere = new ResponsableFinanciere();
        responsableFinanciere.setNom(responsableFinanciereDTO.getNom());
        responsableFinanciere.setPrenom(responsableFinanciereDTO.getPrenom());
        responsableFinanciere.setEmail(responsableFinanciereDTO.getEmail());
        responsableFinanciere.setImage(responsableFinanciereDTO.getImage());
        responsableFinanciere.setTelephone(responsableFinanciereDTO.getTelephone());
        responsableFinanciere.setPassword(responsableFinanciereDTO.getPassword());
        responsableFinanciere.setRoles(new ArrayList<>(Arrays.asList(new Role("ResponsableFinanciere"))));
        responsableFinanciere.setLabo(laboRepository.findById(IdLabo).get());
        responsableFinanciere.setExpressionDesBesoins(null);
        return responsableFinanciereRepository.save(responsableFinanciere);

    }

    @Override
    public ResponsableMarchandise respoMarAdd(ResponsableMarchandiseDTO responsableMarchandiseDTO, int IdLabo) {

        ResponsableMarchandise responsableMarchandise = new ResponsableMarchandise();
        responsableMarchandise.setNom(responsableMarchandiseDTO.getNom());
        responsableMarchandise.setPrenom(responsableMarchandiseDTO.getPrenom());
        responsableMarchandise.setEmail(responsableMarchandiseDTO.getEmail());
        responsableMarchandise.setTelephone(responsableMarchandiseDTO.getTelephone());
        responsableMarchandise.setImage(responsableMarchandiseDTO.getImage());
        responsableMarchandise.setPassword(responsableMarchandiseDTO.getPassword());
        responsableMarchandise.setRoles(new ArrayList<>(Arrays.asList(new Role("ResponsableMarchandise"))));
        responsableMarchandise.setLabo(laboRepository.findById(IdLabo).get());
        responsableMarchandise.setExpressionDesBesoins(null);
        return responsableMarchandiseRepository.save(responsableMarchandise);
    }

    @Override
    public void respoFinDelete(int id) {
        responsableFinanciereRepository.deleteById(id);
    }

    @Override
    public void updateRespoFin(int id, ResponsableFinanciereDTO responsableFinanciereDTO, int IdLabo) {
        ResponsableFinanciere responsableFinanciere = responsableFinanciereRepository.findById(id).get();
        responsableFinanciere.setNom(responsableFinanciereDTO.getNom());
        responsableFinanciere.setPrenom(responsableFinanciereDTO.getPrenom());
        responsableFinanciere.setEmail(responsableFinanciereDTO.getEmail());
        responsableFinanciere.setImage(responsableFinanciereDTO.getImage());
        responsableFinanciere.setTelephone(responsableFinanciereDTO.getTelephone());
        responsableFinanciere.setPassword(responsableFinanciereDTO.getPassword());
        responsableFinanciere.setRoles(new ArrayList<>(Arrays.asList(new Role("ResponsableFinanciere"))));
        responsableFinanciere.setLabo(laboRepository.findById(IdLabo).get());
        responsableFinanciere.setExpressionDesBesoins(null);
        responsableFinanciereRepository.save(responsableFinanciere);
    }

    @Override
    public void respoMarDelete(int id) {
        responsableMarchandiseRepository.deleteById(id);
    }

    @Override
    public void updteRespoMrch(int id, ResponsableMarchandiseDTO responsableMarchandiseDTO, int IdLabo) {
        ResponsableMarchandise responsableMarchandise = responsableMarchandiseRepository.findById(id).get();
        responsableMarchandise.setNom(responsableMarchandiseDTO.getNom());
        responsableMarchandise.setPrenom(responsableMarchandiseDTO.getPrenom());
        responsableMarchandise.setEmail(responsableMarchandiseDTO.getEmail());
        responsableMarchandise.setTelephone(responsableMarchandiseDTO.getTelephone());
        responsableMarchandise.setImage(responsableMarchandiseDTO.getImage());
        responsableMarchandise.setPassword(responsableMarchandiseDTO.getPassword());
        responsableMarchandise.setRoles(new ArrayList<>(Arrays.asList(new Role("ResponsableMarchandise"))));
        responsableMarchandise.setLabo(laboRepository.findById(IdLabo).get());
        responsableMarchandise.setExpressionDesBesoins(null);
        responsableMarchandiseRepository.save(responsableMarchandise);
    }
}
