package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Labo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaboRepository extends JpaRepository<Labo,Integer> {

}
