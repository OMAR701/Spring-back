package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface MembreRepository extends JpaRepository<Membre, Integer> {
}
