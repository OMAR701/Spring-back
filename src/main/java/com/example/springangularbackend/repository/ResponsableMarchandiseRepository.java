package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.ResponsableMarchandise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsableMarchandiseRepository extends JpaRepository<ResponsableMarchandise, Integer> {
}
