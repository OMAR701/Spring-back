package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByEmail(String email);
}
