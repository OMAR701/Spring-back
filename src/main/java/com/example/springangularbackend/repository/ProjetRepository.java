package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjetRepository extends JpaRepository<Projet, Integer> {


}
