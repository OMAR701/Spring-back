package com.example.springangularbackend.service.impl;
import com.example.springangularbackend.model.Person;

import com.example.springangularbackend.repository.PersonRepository;
import com.example.springangularbackend.service.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public void save(Person person){
        personRepository.save(person);
    }
}
