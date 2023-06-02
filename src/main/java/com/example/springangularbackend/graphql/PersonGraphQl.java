package com.example.springangularbackend.graphql;



import com.example.springangularbackend.model.Person;
import com.example.springangularbackend.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonGraphQl {

    @Autowired
    PersonServiceImpl personService;


    @QueryMapping
    public Optional<Person> getPerson(@Argument int id) {

        return personService.getPersonById(id);
    }
    @QueryMapping
    public Optional<Person> personEMAIL(@Argument String email) {
        return personService.getPersonByEmail(email);
    }


    @QueryMapping
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }
}
