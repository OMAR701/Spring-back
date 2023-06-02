package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Dotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotationRepository extends JpaRepository<Dotation, Integer> {

}
