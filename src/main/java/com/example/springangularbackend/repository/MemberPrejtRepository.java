package com.example.springangularbackend.repository;


import com.example.springangularbackend.model.MembreProjet;
import com.example.springangularbackend.model.MembreProjetKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPrejtRepository extends JpaRepository<MembreProjet, MembreProjetKey> {

}
