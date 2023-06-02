package com.example.springangularbackend.service;

import com.example.springangularbackend.dto.*;
import com.example.springangularbackend.model.*;

public interface AdminService {


    public Directeur AddDirecteur(DirecteurDTO directeurDTO);
    public void deleteDirecteur(int id);
    public Labo AddLabo(LaboDTO laboDTO);
    public void affectDirecteurToLabo(int idDirecteur , int IdLabo);

    public ResponsableFinanciere respoFinAdd(ResponsableFinanciereDTO responsableFinanciereDTO);
    public ResponsableMarchandise respoMarAdd(ResponsableMarchandiseDTO responsableMarchandiseDTO);
    public ResponsableFinanciere  respoFinDelete(int id);
    public ResponsableMarchandise respoMarDelete(int id);

}
