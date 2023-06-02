package com.example.springangularbackend.repository;


import com.example.springangularbackend.model.DotationMembre;
import com.example.springangularbackend.model.DotationMembreKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotationMemberRepository extends JpaRepository<DotationMembre, DotationMembreKey> {
}
