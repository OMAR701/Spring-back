package com.example.springangularbackend.graphql;


import com.example.springangularbackend.dto.ProjectDTO;
import com.example.springangularbackend.model.Projet;
import com.example.springangularbackend.service.impl.ProjetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProjetGraphql {

    @Autowired
    ProjetServiceImpl projetService;

    @QueryMapping
    public List<Projet> getProjet(){
        return projetService.getAllProject();
    }
    @QueryMapping
    public Projet getProject(int id){
        return projetService.getProejet(id).get();
    }

    @MutationMapping
    public Projet addProjet(@Argument ProjectDTO projectDTO){
        return projetService.addProjet(projectDTO);
    }

    @MutationMapping
    public boolean UpdateProjet(@Argument int id,@Argument ProjectDTO projectDTO){
        return projetService.UpdateProjet(id, projectDTO);

    }

    @MutationMapping
    public boolean deleteProjet(@Argument int id) {
        projetService.deleteProjet(id);
        return  true;
    }


}
