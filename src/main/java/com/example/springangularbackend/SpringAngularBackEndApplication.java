package com.example.springangularbackend;

import com.example.springangularbackend.config.GraphQLConfig;
import com.example.springangularbackend.model.Directeur;
import com.example.springangularbackend.model.Person;
import com.example.springangularbackend.model.Role;
import com.example.springangularbackend.service.impl.PersonServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class SpringAngularBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularBackEndApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(PersonServiceImpl personService) {
//        return args -> {
//            Person person = new Directeur();
//            person.setNom("kader");
//            person.setEmail("omar@gmail.com");
//            person.setPassword("password");
//            person.setPrenom("omar");
//            person.setTelephone("06534343453");
//            person.setRoles(Arrays.asList(new Role("admin")));
//            personService.save(person);
//        };
//    }


}
