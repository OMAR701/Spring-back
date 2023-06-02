package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Directeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface DirecteurRepository extends JpaRepository<Directeur,Integer> {



}
