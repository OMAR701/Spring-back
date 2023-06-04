package com.example.springangularbackend.service;

import com.example.springangularbackend.dto.PersonDTO;
import com.example.springangularbackend.model.Person;

import java.util.List;
import java.util.Optional;
public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPersonByEmail(String email);
    Optional<Person> getPersonById(int id);

    public void save(Person person);

    public Person addPerson(PersonDTO personDTO);
}
