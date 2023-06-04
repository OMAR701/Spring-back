package com.example.springangularbackend.service;

import com.example.springangularbackend.dto.*;
import com.example.springangularbackend.model.*;
import com.example.springangularbackend.repository.ResponsableMarchandiseRepository;

import java.util.List;

public interface AdminService {


    public Directeur AddDirecteur(DirecteurDTO directeurDTO,  List<Integer> listProjets, List<Integer> listDotations);
    public void updateDirecteur(int id,DirecteurDTO directeurDTO,List<Integer> listProjets, List<Integer> dotationList);
    public void deleteDirecteur(int id);
    public Labo AddLabo(LaboDTO laboDTO ,int directeur, int RespoMarch, int RespoFinan, int idEta);
    public Labo UpdateLabo(int id,LaboDTO laboDTO ,int directeur, int RespoMarch, int RespoFinan, int idEta);
    public void DeleteLabo(int id);
    public Etablisment AddEtablissmenet(EtablismentDTO etablismentDTO, List<Integer> listLabo);
    public Etablisment UpdateEtablisment(int id, EtablismentDTO etablismentDTO, List<Integer> listLabo);
    public void DeleteEtablissement(int id);
    public void updateLbo(int id, LaboDTO laboDTO, int directeur,int RespoMarch, int RespoFinan, int idEta);
//    public void affectDirecteurToLabo(int idDirecteur , int IdLabo);
    public ResponsableFinanciere respoFinAdd(ResponsableFinanciereDTO responsableFinanciereDTO,  int IdLabo);
    public void  respoFinDelete(int id);
    public void updateRespoFin(int id, ResponsableFinanciereDTO responsableFinanciereDTO, int IdLabo);
    public ResponsableMarchandise respoMarAdd(ResponsableMarchandiseDTO responsableMarchandiseDTO, int IdLabo);
    public void respoMarDelete(int id);
    public void updteRespoMrch(int id, ResponsableMarchandiseDTO responsableMarchandiseDTO, int IdLabo);

}
